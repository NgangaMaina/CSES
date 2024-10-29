/*
* Calculate the no of trailing zeros in the factorial n!
* Don't actually calculate the factorial.
* Just count how many times n! is divisible by 10.
* */

import java.util.Scanner;

public class TrailingZeros {
    public static long countTrailingZeros(long n) {
        long count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long n = sc.nextLong();
            System.out.println(countTrailingZeros(n));
        }
    }
}
