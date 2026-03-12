import java.util.*;
import java.io.*;
public class SubArrDiv {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];

        // Fast input for the array
        String[] tokens = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(tokens[i]);
        }

        long MOD = n;
        long[] freq = new long[n]; //How many prefixes had this remainder
        freq[0] = 1;

        long current = 0;
        long answer = 0;

        for(long val : a) {
            current = (current + val) % MOD;
            if(current < 0) {
                current += MOD;
            }

            answer += freq[(int)current];
            freq[(int)current]++;
        }
        System.out.println(answer);
    }
}
