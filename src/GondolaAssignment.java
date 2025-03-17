import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GondolaAssignment {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader instead of Scanner for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Read input
        int n = Integer.parseInt(st.nextToken()); // Number of children
        int x = Integer.parseInt(st.nextToken()); // Maximum weight

        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // Sort the weights
        Arrays.sort(weights);

        // Use two-pointer approach
        int gondolas = 0;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            gondolas++; // Use a new gondola

            // If we can fit the heaviest and lightest child together
            if (left < right && weights[left] + weights[right] <= x) {
                left++;
                right--;
            } else {
                // Otherwise just take the heaviest child
                right--;
            }
        }

        System.out.println(gondolas);
    }
}