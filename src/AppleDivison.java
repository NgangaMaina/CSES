
/*
* n apples with known weights.
*Divide the apples into 2 groups so that the difference
between the groups is minimal.
*
* SOLN: Bitmasking(represent each possible subset of apples
 where each bit indicates whether the apple is in the 1st group
 or 2nd). Calculate the sums of the two groups and track the min
 difference.
* */

import java.util.Scanner;
public class AppleDivison {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       long[]  weights = new long[n];

       //Read Apple wights:
        for(int i =0; i<n; i++){
            weights[i] = sc.nextLong();
        }

        long totalSum = 0;
        for(long weight: weights){
            totalSum += weight;
        }

        long minDifference = Long.MAX_VALUE;

        //Iterate over all subsets using bitmasking:
        for(int mask = 0; mask<(1 << n); mask++){
            long group1Sum = 0;

            for(int i = 0; i < n; i++){
                //Check if the ith apple is in this group1:
                if((mask & (1 << i)) != 0){
                    group1Sum +=weights[i];
                }
            }

            long group2Sum = totalSum - group1Sum;
            long difference =Math.abs(group1Sum -group2Sum);
            minDifference = Math.min(minDifference, difference);
        }

        System.out.println(minDifference);
    }
}
