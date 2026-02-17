import java.io.*;
import java.util.*;

public class DistinctSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] tokens = br.readLine().trim().split("\\s+");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        final long MOD = 1000000007L;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.merge(x, 1, Integer::sum);
        }

        long result = 1;
        for (int f : freq.values()) {
            result = result * (f + 1) % MOD;
        }

        result = (result - 1 + MOD) % MOD;

        System.out.println(result);
    }
}