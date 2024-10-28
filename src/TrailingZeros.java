/*
* Calculate the no of trailing zeros in the factorial n!
* Don't actually calculate the factorial.
* Just count how many times n! is divisible by 10.
* */

import java.util.Scanner;
public class TrailingZeros {
    // Move method outside main
    public static int countTrailingZeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println("Number of trailing zeros in " + n + "! is: " + countTrailingZeros(n));
        }
    }
}
