import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncreasingOrderRounds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] indices = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            indices[num] = i;  // Store the index of each number
        }

        int rounds = 1;  // Start with one round
        int lastIndex = indices[1];  // Index of the first number

        // Check if each subsequent number forces a new round
        for (int i = 2; i <= n; i++) {
            if (indices[i] < lastIndex) {
                // If the current number appears before the last collected number,
                // we need a new round since we've already passed it
                rounds++;
            }
            lastIndex = indices[i];
        }

        System.out.println(rounds);
    }
}