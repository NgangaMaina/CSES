/*
* Calculate the no of trailing zeros in the factorial n!
* Don't actually calculate the factorial.
* Just count how many times n! is divisible by 10.
* */

import java.util.Scanner;
public class TrailingZeros {
    public static void main(String[] args) {
           Scanner sc =new Scanner(System.in);
           int n = sc.nextInt();

        public static int countTrailingZeros(int n) {
            int count = 0;
            for (int i = 5; n / i >= 1; i *= 5) {
                count += n / i;
            }
            return count;
        }
        System.out.println("Number of trailing zeros in " + n + "! is: " + countTrailingZeros(n));

    }
}
