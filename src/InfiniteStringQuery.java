/*
* The infinite string is composed of concatenated positive integers in increasing order:
123456789101112131415...
* The problem requires finding the digit at a specific 1-indexed position k in this string
* Directly constructing such a string to solve the problem is infeasible because k can go up to 10^18.
Instead, the solution involves:
    -Understanding the structure of the infinite string.
    -Breaking the problem into steps.
* */

import java.util.Scanner;
public class InfiniteStringQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); //Number of queries
        StringBuilder result = new StringBuilder();

        //Iterate through each query
        while(q-- >0){
            long k = sc.nextLong(); //Position to query
            result.append(findDigitAtPosition(k)).append("\n");
        }

        System.out.println(result);
    }

    private static char findDigitAtPosition(long k) {
        long length = 1; //Length of the current group(1 for single-digit, 2 for two-digit, etc.)
        long count = 9; //Count of numbers in the current group(9 for single-digit, 90 for two-digit and so on)
        long start = 1; //Starting number of the current group(1, 10, 100, etc.)

        //Determine the group where the position lies
        while (k > length * count) {
            k -= length * count; //Remove the contribution of the current group
            length++;
            count *= 10;
            start *= 10;
        }

        //Determine the exact number in the group
        long number = start + (k - 1) / length;

        //Determine the specific digit in the number
        String numberStr = Long.toString(number);
        return numberStr.charAt((int) ((k - 1) % length));

    }
}
