import java.io.*;
import java.util.*;

public class NestedRangeCount {

    static int[] bit;

    static void update(int i, int n) {
        while (i <= n) {
            bit[i]++;
            i += i & -i;
        }
    }

    static int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[][] arr = new int[n][3]; // l, r, index
        int[] rights = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = fs.nextInt();
            arr[i][1] = fs.nextInt();
            arr[i][2] = i;
            rights[i] = arr[i][1];
        }

        // Coordinate compression
        Arrays.sort(rights);
        rights = Arrays.stream(rights).distinct().toArray();

        // Sort ranges
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] contains = new int[n];
        int[] contained = new int[n];

        // -------- contained by --------
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(rights, arr[i][1]) + 1;

            contained[arr[i][2]] = query(n) - query(pos - 1);
            update(pos, n);
        }

        // -------- contains --------
        bit = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(rights, arr[i][1]) + 1;

            contains[arr[i][2]] = query(pos);
            update(pos, n);
        }

        // Output
        StringBuilder sb = new StringBuilder();

        for (int x : contains) sb.append(x).append(' ');
        sb.append('\n');
        for (int x : contained) sb.append(x).append(' ');

        System.out.print(sb);
    }


    static class FastScanner {
        BufferedInputStream in = new BufferedInputStream(System.in);
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;

            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}
