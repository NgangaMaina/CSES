import java.util.*;
public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int x = 1; x <=n; x++) {
            dp[x] = x;
            int temp = x;
            while(temp > 0) {
                int d = temp % 10;
                if(d > 0) {
                    dp[x] = Math.min(dp[x], 1 + dp[x - d]);
                }

                temp /= 10;
            }
        }

        System.out.println(dp[n]);
    }
}
