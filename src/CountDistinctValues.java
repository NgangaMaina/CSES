import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CountDistinctValues {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader instead of Scanner for faster I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of values
        int n = Integer.parseInt(br.readLine().trim());

        // Use a HashSet to track distinct values
        Set<Integer> distinctValues = new HashSet<>();

        // Read all integers at once and process them
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            distinctValues.add(Integer.parseInt(st.nextToken()));
        }

        // Print the number of distinct values
        System.out.println(distinctValues.size());
    }
}