import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ApartmentAllocation {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader instead of Scanner for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // Number of applicants
        int m = Integer.parseInt(st.nextToken()); // Number of apartments
        int k = Integer.parseInt(st.nextToken()); // Maximum allowed difference

        // Read applicant sizes
        int[] applicants = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            applicants[i] = Integer.parseInt(st.nextToken());
        }

        // Read apartment sizes
        int[] apartments = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Integer.parseInt(st.nextToken());
        }

        // Sort both arrays
        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int allocatedCount = 0;
        int j = 0; // Pointer for apartments

        // Optimization: Use a more efficient implementation of the greedy algorithm
        for (int i = 0; i < n && j < m; i++) {
            // Find the first apartment that is suitable for the current applicant
            while (j < m && apartments[j] < applicants[i] - k) {
                j++;
            }

            // If we found a suitable apartment
            if (j < m && apartments[j] <= applicants[i] + k) {
                allocatedCount++;
                j++; // Move to next apartment
            }
        }

        System.out.println(allocatedCount);
    }
}