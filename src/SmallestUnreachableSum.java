import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SmallestUnreachableSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of coins
        int n = Integer.parseInt(br.readLine().trim());

        // Read coin values
        int[] coins = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // Use faster sort and optimize by avoiding sorting if unnecessary
        if (n <= 1) {
            if (n == 0 || coins[0] > 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
            return;
        }

        Arrays.sort(coins);

        // If the smallest coin is greater than 1, we can't create 1
        if (coins[0] > 1) {
            System.out.println(1);
            return;
        }

        // Find the smallest unreachable sum
        long reachableSum = 0;
        for (int coin : coins) {
            // If the current coin value is greater than reachableSum + 1,
            // then we found a gap
            if (coin > reachableSum + 1) {
                System.out.println(reachableSum + 1);
                return;
            }

            // Otherwise, we can extend our reachable sum
            reachableSum += coin;

            // Check for overflow
            if (reachableSum >= Long.MAX_VALUE - coin) {
                break;
            }
        }

        // If we've gone through all coins without finding a gap
        System.out.println(reachableSum + 1);
    }
}