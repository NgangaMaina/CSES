/*
* divide numbers 1, 2, ....n into sets of equal sum:
* S = n(n + 1) /2.
* if S is odd, it's impossible to divide the nos. into two sets of
* equal sum (Return NO).
*If S is even, find a way to partition the nos. into two sets with equal sum.
* */

import java.util.ArrayList;
import java.util.Scanner;

public class EqualSumSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = (long) n * (n + 1) / 2;

        if (sum % 2 != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            ArrayList<Integer> set1 = new ArrayList<>();
            ArrayList<Integer> set2 = new ArrayList<>();

            long targetSum = sum / 2;
            long currentSum = 0;


            for (int i = n; i >= 1; i--) {
                if (currentSum + i <= targetSum) {
                    set1.add(i);
                    currentSum += i;
                } else {
                    set2.add(i);
                }
            }


            StringBuilder sb = new StringBuilder();
            sb.append(set1.size()).append("\n");
            for (int num : set1) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            sb.append(set2.size()).append("\n");
            for (int num : set2) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            // Output all at once
            System.out.print(sb.toString());
        }
        sc.close();
    }
}
