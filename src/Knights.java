/*
* for k = 1, 2, ....n the number of ways 2 knights can be placed on
* a k * k board so that they do not attack each other.
* input => n
* output => n integers.
* */

import java.util.Scanner;
public class Knights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int k = 1; k <= n; k++ ) {
            long totalWays = (long) k * k * ((long) k * k - 1)/ 2;

            long attackingPairs = 0;
            if(k > 2) {
                attackingPairs = 4L * (k - 1) * (k - 2);
            }

            long nonAttackingPairs = totalWays - attackingPairs;
            System.out.println(nonAttackingPairs);
        }
        sc.close();
    }
}
