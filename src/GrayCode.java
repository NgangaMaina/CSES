/*
*Gray Code - List of all 2^n bit strings of length n where any two successive
* string s differ in exactly one bit.
*input -> int n
* Output -> 2^n lines that describe gray code.
* Gray codes for a given length can be constructed recursively or using bit manipulation.
*
* */

import java.util.Scanner;
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int numGrayCodes = 1 << n;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numGrayCodes; i++){
            int grayCode = i ^ (i >> 1); //Generate the gray code using bit manipulation.
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(grayCode))
                    .replace(' ', '0'); // Format to n bits with leading zeros
            result.append(binaryString).append("\n");
        }

        System.out.println(result);
    }
}
