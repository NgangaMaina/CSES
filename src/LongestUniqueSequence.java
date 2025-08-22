import java.io.*;
import java.util.*;

public class LongestUniqueSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] songs = new int[n];

        for (int i = 0; i < n; i++) {
            songs[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(longestUniqueSequence(songs));
    }

    public static int longestUniqueSequence(int[] songs) {
        if (songs.length == 0) return 0;

        // Coordinate compression
        Set<Integer> uniqueSongs = new HashSet<>();
        for (int song : songs) {
            uniqueSongs.add(song);
        }

        // Create mapping from song ID to compressed index
        Map<Integer, Integer> compress = new HashMap<>();
        int idx = 0;
        for (int song : uniqueSongs) {
            compress.put(song, idx++);
        }

        // Array to store last seen position (much faster than HashMap)
        int[] lastSeen = new int[uniqueSongs.size()];
        Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < songs.length; right++) {
            int compressedSong = compress.get(songs[right]);

            // If we've seen this song before and it's in our current window
            if (lastSeen[compressedSong] >= left) {
                left = lastSeen[compressedSong] + 1;
            }

            // Update the last seen position
            lastSeen[compressedSong] = right;

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}