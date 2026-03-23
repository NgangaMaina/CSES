import java.util.*;
public class DiceCombi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long MOD = 1_000_000_007L;

        if(n == 0) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        long windowSum = 0;
        for(int i = 1; i <= n; i++) {
            windowSum = (windowSum + dp[i - 1]) % MOD;

            if(i - 7 >= 0 ) {
                windowSum = (windowSum - dp[i - 7] + MOD) % MOD;
            }
            dp[i] = windowSum;
        }
        System.out.println(windowSum);
    }
}
