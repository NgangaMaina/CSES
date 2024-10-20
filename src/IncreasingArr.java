/*
* Given arr of n ints. Modify so that it's increasing.
* increase value by 1 on each move.
* Minimum no of move required?
* */


import java.util.Scanner;

import java.util.Scanner;

public class IncreasingArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long moves = 0;

        // Start from the second element and compare with the previous one
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                // Calculate how many moves are required to make arr[i] >= arr[i-1]
                moves += (long) arr[i - 1] - arr[i];
                arr[i] = arr[i - 1]; // Set arr[i] to arr[i - 1]
            }
        }

        System.out.println(moves);
        scanner.close();
    }
}

