import java.io.*;

public class MinTimeToProduce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        long t = Long.parseLong(first[1]);

        long[] k = new long[n];
        long maxK = 0;

        String[] times = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            k[i] = Long.parseLong(times[i]);
            if (k[i] > maxK) maxK = k[i];
        }

        // Sort ascending → early termination much more likely
        java.util.Arrays.sort(k);

        long low = 0;   // or 1 — 0 is fine, check handles it
        long high = t * maxK + 1;   // +1 to be safe

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canProduce(mid, k, t)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    private static boolean canProduce(long time, long[] k, long target) {
        long total = 0;
        for (long ki : k) {
            total += time / ki;

            //early exit as soon as possible
            if (total >= target) {
                return true;
            }
        }
        return total >= target;
    }
}