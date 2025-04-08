import java.io.*;

public class RestaurantCustomers {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        // Create two arrays to separately store all times and their corresponding types
        long[] times = new long[2 * n];  // Using long to handle very large numbers
        int[] types = new int[2 * n];

        for (int i = 0; i < n; i++) {
            times[2 * i] = reader.nextLong();     // arrival time
            types[2 * i] = 1;                     // arrival = +1

            times[2 * i + 1] = reader.nextLong(); // departure time
            types[2 * i + 1] = -1;                // departure = -1
        }

        // Use a faster variant of merge sort (avoid potential QuickSort worse cases)
        mergeSort(times, types, 0, 2 * n - 1);

        // Count maximum concurrent customers
        int current = 0;
        int max = 0;

        for (int i = 0; i < 2 * n; i++) {
            current += types[i];
            max = Math.max(max, current);
        }

        System.out.println(max);
    }

    // Custom merge sort implementation optimized for this specific problem
    private static void mergeSort(long[] times, int[] types, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(times, types, left, mid);
            mergeSort(times, types, mid + 1, right);

            merge(times, types, left, mid, right);
        }
    }

    private static void merge(long[] times, int[] types, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] leftTimes = new long[n1];
        int[] leftTypes = new int[n1];
        long[] rightTimes = new long[n2];
        int[] rightTypes = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftTimes[i] = times[left + i];
            leftTypes[i] = types[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightTimes[i] = times[mid + 1 + i];
            rightTypes[i] = types[mid + 1 + i];
        }

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftTimes[i] < rightTimes[j] || (leftTimes[i] == rightTimes[j] && leftTypes[i] > rightTypes[j])) {
                times[k] = leftTimes[i];
                types[k] = leftTypes[i];
                i++;
            } else {
                times[k] = rightTimes[j];
                types[k] = rightTypes[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            times[k] = leftTimes[i];
            types[k] = leftTypes[i];
            i++;
            k++;
        }
        while (j < n2) {
            times[k] = rightTimes[j];
            types[k] = rightTypes[j];
            j++;
            k++;
        }
    }

    // Ultra-optimized input reader
    static class FastReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024 * 1024]; // 1MB buffer
        private int curChar;
        private int numChars;

        public FastReader() {
            this.stream = System.in;
        }

        private int read() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private static class InputMismatchException extends RuntimeException {
        }
    }
}