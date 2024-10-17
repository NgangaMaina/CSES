/*
* The Algo takes as an input a +ve int n.
*  if n == even, /2; if n == odd *3+1
* Repeat until n == 1.
*
* */

import java.util.Scanner;
public class Collatz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        System.out.println(n);

        while(n != 1) {
            if(n%2 == 0) {
                n = n/2;
            }else{
                n = n * 3 + 1;
            }
            System.out.println(" " + n);
        }
        System.out.println();
    }
}
