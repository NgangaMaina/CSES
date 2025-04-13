import java.util.Arrays;
import java.util.Scanner;

public class StickEqualizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Read the number of sticks
        int n = sc.nextInt();

        //Read the lengths of the sticks
        int[] lengths = new int[n];
        for(int i = 0; i < n; i++) {
            lengths[i] = sc.nextInt();
        }

        //Sort the array to find the median easily
        Arrays.sort(lengths);

        //The median minimizes the sum of the absolute differences
        int medianIndex = n/2;
        int medianLength = lengths[medianIndex];

        //Calculate the total cost
        long totalCost = 0;
        for(int length : lengths) {
            totalCost += Math.abs(length - medianLength);
        }

        System.out.println(totalCost);
        sc.close();
    }

}
