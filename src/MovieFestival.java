import java.io.*;
import java.util.*;

public class MovieFestival {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader instead of Scanner for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Use primitive arrays instead of objects for better memory and speed
        int[][] movies = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            movies[i][0] = Integer.parseInt(st.nextToken()); // Start time
            movies[i][1] = Integer.parseInt(st.nextToken()); // End time
        }

        // Sort by end time using a custom comparator
        Arrays.sort(movies, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int currentEnd = 0;

        // Greedy selection of non-overlapping movies
        for (int[] movie : movies) {
            if (movie[0] >= currentEnd) {
                // We can watch this movie
                count++;
                currentEnd = movie[1];
            }
        }

        // Use BufferedWriter for faster output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.newLine();
        bw.flush();
    }
}