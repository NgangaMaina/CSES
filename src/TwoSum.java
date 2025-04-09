import java.io.*;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // Read array values with indices
        st = new StringTokenizer(br.readLine());
        int[][] valuesWithIndices = new int[n][2];

        for (int i = 0; i < n; i++) {
            valuesWithIndices[i][0] = Integer.parseInt(st.nextToken());
            valuesWithIndices[i][1] = i + 1; // Store 1-indexed position
        }

        // Sort by value
        Arrays.sort(valuesWithIndices, Comparator.comparingInt(a -> a[0]));

        // Use two pointers approach
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = valuesWithIndices[left][0] + valuesWithIndices[right][0];

            if (sum == target) {
                // Found the answer
                System.out.println(valuesWithIndices[left][1] + " " + valuesWithIndices[right][1]);
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // No solution found
        System.out.println("IMPOSSIBLE");
    }
}