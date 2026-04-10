import java.util.*;
import java.io.*;
public class CountingTowers {
    public static void main(String[] args) throws IOException {
        final long MOD = 1000000007L;
        final int MAX_N = 1000000;

        long[] A = new long[MAX_N + 1];
        long[] B = new long[MAX_N + 1];
        long[] ans = new long[MAX_N + 1];

        A[1] = 1;
        B[1] = 1;
        ans[1] = 2;

        for(int i = 2; i <= MAX_N; i++) {
            A[i] = (2 * A[i - 1] % MOD + B[i - 1]) % MOD;
            B[i] = (A[i - 1] + 4 * B[i - 1] % MOD) % MOD;
            ans[i] = (A[i] + B[i]) % MOD;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(ans[n]).append("\n");
        }
        System.out.println(sb);
    }
}
