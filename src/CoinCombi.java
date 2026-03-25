import java.util.*;
public class CoinCombi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        final long MOD = 1000000007L;

        long[] dp = new long[x + 1];
        dp[0] = 1;

        for(int j = 1; j <= x; j++) {
            for(int c : coins) {
                if(j >= c){
                    dp[j] = (dp[j] + dp[j - c]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);

        sc.close();
    }

}
