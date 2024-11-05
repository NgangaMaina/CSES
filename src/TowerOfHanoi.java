
import java.util.Scanner;
public class TowerOfHanoi {
    private static int movesCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //Calculate and print the min no of moves:
        int minMoves = (1 << n) - 1;
        System.out.println(minMoves);

        solveHanoi(n, 1, 3, 2);
    }

    public static void solveHanoi(int n, int from, int to, int aux) {
        if (n == 1){
            System.out.println(from + " " + to );
            movesCount++;
                    return;
        }

        solveHanoi(n - 1, from, aux, to);

        System.out.println(from + " " + to);
        movesCount++;

        solveHanoi(n - 1, aux, to, from);
    }
}
