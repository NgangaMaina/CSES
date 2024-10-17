/*
* Given DNA sequence with chars; A, C, G, T.
* Only input line contains a string of n chars
* Print one int: length of longest repetition.
* */

import java.util.Scanner;
public class Repetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dna = scanner.nextLine();
        scanner.close();

        if (dna.isEmpty()) {
            System.out.println(0);
        }

        int maxLength = 1;
        int currentLength = 1;

        for(int i = 1; i < dna.length(); i++) {
            if(dna.charAt(i) == dna.charAt(i - 1)){
                currentLength++;
            }else{
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        maxLength = Math.max(maxLength, currentLength);
        System.out.println(maxLength);

    }
}
