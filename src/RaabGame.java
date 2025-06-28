import java.util.*;

public class RaabGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();  // Number of cards
            int a = sc.nextInt();  // Player 1's score
            int b = sc.nextInt();  // Player 2's score

            if (a + b > n) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            int[] p1 = new int[n];
            int[] p2 = new int[n];
            boolean[] used = new boolean[n + 1]; // to avoid duplicates

            int index = 0;
            int high = n;
            int low = 1;

            // Player 1 wins 'a' rounds
            for (int i = 0; i < a; i++) {
                p1[index] = high;
                p2[index] = low;
                used[high] = true;
                used[low] = true;
                index++;
                high--;
                low++;
            }

            // Player 2 wins 'b' rounds
            for (int i = 0; i < b; i++) {
                p1[index] = low;
                p2[index] = high;
                used[high] = true;
                used[low] = true;
                index++;
                high--;
                low++;
            }

            // Fill remaining positions with unused equal cards
            for (int i = 1; i <= n && index < n; i++) {
                if (!used[i]) {
                    p1[index] = i;
                    p2[index] = i;
                    index++;
                }
            }

            // Print player 1's card order
            for (int i = 0; i < n; i++) {
                System.out.print(p1[i] + " ");
            }
            System.out.println();

            // Print player 2's card order
            for (int i = 0; i < n; i++) {
                System.out.print(p2[i] + " ");
            }
            System.out.println();
        }
    }
}
