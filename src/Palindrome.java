/*
* Given a string, reorder the letters to read the
* same forward and backwards
*
* Rqmts for palindrome formation:
*   -Even-length string (For a string with an even length, each character must appear an even number of times. This
*    allows for characters to be mirrored around the center.)
*   -Odd-length string ( For a string with an odd length, all but one character must appear an even number of times. The character with an odd
*     count will be placed in the center of the palindrome.)
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       sc.close();

       //Count the frequency of each character:
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch: input.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        //Check palindrome conditions:
        int oddCount = 0;
        char oddChar =0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            if(entry.getValue() % 2 != 0){
                oddCount++;
                oddChar = entry.getKey();
            }
        }

        //If more than one character has an odd frequency, no  palindrome is possible:
        if(oddCount > 1){
            System.out.println("NO SOLUTION");
            return;
        }

        //Build the Palindrome:
        StringBuilder halfPalindrome = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();

          if(freq % 2 == 0){
              for(int i =0; i < freq/2; i++){
                  halfPalindrome.append(ch);
              }
          }else{
              for(int i = 0; i < freq/2; i++ ){
                  halfPalindrome.append(ch);
              }
              middle.append(ch);
          }
        }

        String palindrome = halfPalindrome.toString() + middle.toString() + halfPalindrome.reverse().toString();
        System.out.println(palindrome);
    }
}
