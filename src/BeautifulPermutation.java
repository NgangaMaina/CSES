/*
* Beautiful Permutation - No adjacent elements whose difference is 1.
*input -> Integer n.
*output -> Beautiful permutation of integers 1, 2, ....n.
* */


import java.util.Scanner;
public class BeautifulPermutation {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();

         if(n == 1){
             System.out.println(1);
         }else if(n == 2 || n == 3){
             System.out.println("NO SOLUTION");
         }else{
             // for n > 3, we print all even numbers followed by odd numbers:
             StringBuilder result = new StringBuilder();

             for(int i = 2; i<= n; i+= 2){
                 result.append(i).append(" ");

             }
             for(int i = 1; i<=n; i +=2 ){
                 result.append(i).append(" ");
             }

             System.out.println(result.toString().trim());
         }
         sc.close();
    }
}
