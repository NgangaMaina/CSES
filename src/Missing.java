/*
* Given a list of integers except 1
* 1st line input ⊃ int n
* 2nd line input ⊃ n - 1
* Each number is distinct btwn 1 & n
*
* Find the missing number??
* */

import java.util.Scanner;
public class Missing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long totalSum = (long) n * (n + 1) / 2;

        long sum = 0;
        for(int i = 0; i < n - 1; i++){
            sum += scanner.nextInt();
        }

        System.out.println(totalSum - sum);
        scanner.close();
    }
}

