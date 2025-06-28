import java.util.Scanner;

public class RaabGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a + b > n) {
                System.out.println("NO");
            } else {
                System.out.println("YES");

                // Player A's sequence
                int[] aCards = new int[n];
                int[] bCards = new int[n];

                // Fill A's and B's cards for A wins (first a turns)
                for (int i = 0; i < a; i++) {
                    aCards[i] = n - i; // A's highest cards
                    bCards[i] = i + 1; // B's lowest cards
                }

                // Fill A's and B's cards for B wins (next b turns)
                for (int i = 0; i < b; i++) {
                    aCards[a + i] = a + i + 1; // A's next cards
                    bCards[a + i] = n - b + i + 1; // B's highest remaining cards
                }

                // Fill remaining cards for ties (last n - a - b turns)
                int tieIndex = a + b;
                for (int i = a + b; i < n; i++) {
                    int val = tieIndex + 1;
                    aCards[i] = val;
                    bCards[i] = val;
                    tieIndex++;
                }

                // Print A's sequence
                for (int i = 0; i < n; i++) {
                    System.out.print(aCards[i] + (i < n - 1 ? " " : ""));
                }
                System.out.println();

                // Print B's sequence
                for (int i = 0; i < n; i++) {
                    System.out.print(bCards[i] + (i < n - 1 ? " " : ""));
                }
                System.out.println();
            }
        }
        sc.close();
    }
}