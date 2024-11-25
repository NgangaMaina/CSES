/*
* Generating all different possible strings from chars
* of an input string.
* Backtracking approach to generate the permutations. (Java's TreeSet)
* If input contains duplicates, the TreeSet will eliminate them and keep the permutation sorted.
* */

import java.util.*;
public class Strings {
    private static final TreeSet<String> permutationsSet = new TreeSet<>();
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       sc.close();

       generatePermutations(input.toCharArray(), 0); //Generating all permutations.

        System.out.print(permutationsSet.size() +"\n");

        for(String permutation : permutationsSet){
            System.out.print(permutation +"\n");
        }
    }

    //Recursive function to generate permutations.
    private static void generatePermutations(char[] chars, int index){
        if(index == chars.length){
            permutationsSet.add(new String(chars));
            return;
        }

        //Using set to avoid duplicate swaps at this level:
        HashSet<Character> seen = new HashSet<>();

        for (int i = index; i < chars.length; i++){
            if(!seen.contains(chars[i])){
                seen.add(chars[i]);
                //Swap current index with i:
                swap(chars, index,i);

                //recursively generate permutations for the next index
                generatePermutations(chars, index + 1);

                //Swap back to backtrack
                swap(chars, index, i);
            }
        }
    }

    //Utility function to swap characters in an array:
    private static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

