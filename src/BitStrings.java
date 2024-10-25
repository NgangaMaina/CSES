/*
* Number of bit Strings of length n
* Total bit strings = 2^n
* */

import java.util.Scanner;
public class BitStrings {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        sc.close();

        long result = modularExponentiation(2, n);
        System.out.println(result);
    }


    private static long modularExponentiation(int base, int exponent){
             long result = 1;
             long power = base;

             while (exponent > 0) {
                 if((exponent & 1) == 1){
                     result = (result * power) % MOD;
                 }
                 power = (power * power) % MOD;
                 exponent >>=1;
        }
             return result;
     }
}
