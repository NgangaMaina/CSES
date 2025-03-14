/*
* This problem is about counting valid paths in a grid that match a given description, where '?'
can represent any of the four directions (D, U, L, R).We must traverse the grid from the upper-left to the
lower-left corner (7×7 grid) following the constraints given in the path description.
* */

import java.util.Scanner;

public class GridPaths {
    private static final int GRID_SIZE = 7;
    private static final int PATH_LENGTH = 48;
    private static final int TARGET_ROW = GRID_SIZE - 1;
    private static final int TARGET_COL = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        scanner.close();

        System.out.println(countPaths(description));
    }

    private static long countPaths(String description) {
        // Create memoization array
        Long[][][] memo = new Long[PATH_LENGTH + 1][GRID_SIZE][GRID_SIZE];

        // Start the recursion from the upper-left corner (0,0)
        return solve(description, 0, 0, 0, memo);
    }

    private static long solve(String description, int pos, int row, int col, Long[][][] memo) {
        // Check if we're out of bounds
        if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
            return 0;
        }

        // If we've reached the target before using all moves, this is not a valid path
        if (row == TARGET_ROW && col == TARGET_COL && pos < PATH_LENGTH) {
            return 0;
        }

        // Base case: reached the end of the path
        if (pos == PATH_LENGTH) {
            // Check if we're at the target (bottom-left corner)
            return (row == TARGET_ROW && col == TARGET_COL) ? 1 : 0;
        }

        // If we've already computed this state, return the cached result
        if (memo[pos][row][col] != null) {
            return memo[pos][row][col];
        }

        // Optimization: Check if we can reach the target in the remaining moves
        int remainingMoves = PATH_LENGTH - pos;
        int minMovesToTarget = Math.abs(row - TARGET_ROW) + Math.abs(col - TARGET_COL);

        // If we can't physically reach the target in the remaining moves, return 0
        if (minMovesToTarget > remainingMoves) {
            memo[pos][row][col] = 0L;
            return 0;
        }

        // If parity doesn't match, we can't reach the target
        // For each move, parity of (row+col) changes, so if remaining moves and distance
        // don't have the same parity, we can't reach the target
        if ((minMovesToTarget % 2) != (remainingMoves % 2)) {
            memo[pos][row][col] = 0L;
            return 0;
        }

        // Current direction to check
        char direction = description.charAt(pos);
        long paths = 0;

        // Try all possible moves based on the current character
        if (direction == 'D' || direction == '?') {
            paths += solve(description, pos + 1, row + 1, col, memo);
        }

        if (direction == 'U' || direction == '?') {
            paths += solve(description, pos + 1, row - 1, col, memo);
        }

        if (direction == 'L' || direction == '?') {
            paths += solve(description, pos + 1, row, col - 1, memo);
        }

        if (direction == 'R' || direction == '?') {
            paths += solve(description, pos + 1, row, col + 1, memo);
        }

        // Store the result in the memo array
        memo[pos][row][col] = paths;
        return paths;
    }
}





