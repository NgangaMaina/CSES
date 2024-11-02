/*
* Coin piles with a and b coins.
* on a move: remove 1 from left pile OR 2 from right pile OR vice versa.
* Find out if you can empty both piles??
* */

import java.util.Scanner;
public class CoinPiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i<t; i++ ){
            long a = sc.nextLong();
            long b = sc.nextLong();

            if((a + b)% 3 == 0 && a <= 2 * b && b <= 2 * b ){
                result.append("YES\n");
            }else{
                result.append("NO\n");
            }
        }

        System.out.println(result);
        sc.close();
    }
}
