/*
* This problem is about counting valid paths in a grid that match a given description, where '?'
can represent any of the four directions (D, U, L, R).We must traverse the grid from the upper-left to the
lower-left corner (7×7 grid) following the constraints given in the path description.
* */

import java.util.*;

public class GridPaths {
    static final int GRID_SIZE = 7; //7x7 grid
    static boolean[][] visited = new boolean[GRID_SIZE][GRID_SIZE];
    static String path; //Input path string
    static int count = 0; //Total valid paths

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        path = sc.next(); //Input string of 48 characters
        visited[0][0] = true; //Start at the top-left corner
        dfs(0, 0, 0); //Begin depth-first search
        System.out.println(count); //Output the total count of valid paths
    }

    // dfs function
    static void dfs(int x, int y, int step) {
        // Base case: Reached bottom-left corner with exactly 48 steps
        if (x == GRID_SIZE - 1 && y == 0) {
            if (step == 48) count++;
            return;
        }

        //Terminate early if steps exceed limit
        if (step >= 48) return;

        //Directions: D, U, L, R
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] directions = {'D', 'U', 'L', 'R'};

        char currentMove = path.charAt(step);

        //Iterate over all possible moves
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //If the current move is not '?' and does not match the direction, skip
            if (currentMove != '?' && currentMove != directions[i]) continue;

            //Skip invalid moves (out of bounds or revisiting a cell)
            if (!isValid(nx, ny)) continue;

            //Mark the cell as visited and proceed with recursion
            visited[nx][ny] = true;
            dfs(nx, ny, step + 1);
            visited[nx][ny] = false; //Backtrack
        }
    }

    //Check if a position is valid
    static boolean isValid(int x, int y) {
        return x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE && !visited[x][y];
    }
}






