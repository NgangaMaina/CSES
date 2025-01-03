import java.util.Scanner;

public class ChessBoards {
    static int[][] board = new int[8][8];
    static int solutions = 0;
    static boolean[] columnUsed = new boolean[8]; // Columns
    static boolean[] primaryDiag = new boolean[15]; // Primary diagonals
    static boolean[] secondaryDiag = new boolean[15]; // Secondary diagonals

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the chessboard configuration
        for (int i = 0; i < 8; i++) {
            String line = scanner.next();
            for (int j = 0; j < 8; j++) {
                board[i][j] = (line.charAt(j) == '.') ? 1 : 0; // 1: Free, 0: Reserved
            }
        }

        // Start placing queens from the first row
        placeQueens(0);
        System.out.println(solutions);
    }

    // Recursive function to place queens row by row
    static void placeQueens(int row) {
        if (row == 8) {
            solutions++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isSafe(row, col)) {
                // Mark the position as occupied
                columnUsed[col] = primaryDiag[row + col] = secondaryDiag[row - col + 7] = true;
                placeQueens(row + 1);
                // Backtrack: Unmark the position
                columnUsed[col] = primaryDiag[row + col] = secondaryDiag[row - col + 7] = false;
            }
        }
    }

    // Check if a queen can be placed at the given row and column
    static boolean isSafe(int row, int col) {
        return board[row][col] == 1 &&
                !columnUsed[col] &&
                !primaryDiag[row + col] &&
                !secondaryDiag[row - col + 7];
    }
}
