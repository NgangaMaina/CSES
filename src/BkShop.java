import java.util.*;
public class BkShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] h = new int[n];
        for(int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        int[] s = new int[n];
        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];

        for(int i = 0; i < n; i++) {
            for(int w = x; w >= h[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - h[i]] + s[i]);
            }
        }

        System.out.println(dp[x]);
    }
}
