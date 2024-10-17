/*
* Given arr of n ints. Modify so that it's increasing.
* increase value by 1 on each move.
* Minimum no of move required?
* */


import java.util.Scanner;

public class IncreasingArr {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();

         int[] arr = new int[n];

         for(int i = 0; i < n; i++) {
             arr[i] = scanner.nextInt();
         }

         int moves = 0;

         for(int i = 0; i < n; i++) {
             if (arr[i] < arr[n - 1]){
                 moves += arr[i - 1] - arr[i];
                 arr[i] = arr[i - 1];
             }
         }

         System.out.println(moves);
         scanner.close();
    }
}
