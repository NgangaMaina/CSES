import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MexGridConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] grid = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                Set<Integer> forbidden = new HashSet<>();

                // Collect numbers to the left in the same row
                for (int j = 0; j < col; j++) {
                    forbidden.add(grid[row][j]);
                }

                // Collect numbers above in the same column
                for (int i = 0; i < row; i++) {
                    forbidden.add(grid[i][col]);
                }

                // Find MEX (minimum excludant) - smallest non-negative not in forbidden
                int value = 0;
                while (forbidden.contains(value)) {
                    value++;
                }

                grid[row][col] = value;
            }
        }

        // Output the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}