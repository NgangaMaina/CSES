import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        // Use faster I/O
        FastIO io = new FastIO();

        int n = io.nextInt();
        int m = io.nextInt();

        // Use TreeMap as a multiset
        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        // Read ticket prices
        for (int i = 0; i < n; i++) {
            int price = io.nextInt();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        // Process customers
        for (int i = 0; i < m; i++) {
            int maxPrice = io.nextInt();
            Integer floorKey = tickets.floorKey(maxPrice);

            if (floorKey == null) {
                io.println("-1");
            } else {
                io.println(floorKey);

                // Update ticket count
                int count = tickets.get(floorKey);
                if (count == 1) {
                    tickets.remove(floorKey);
                } else {
                    tickets.put(floorKey, count - 1);
                }
            }
        }

        io.close();
    }

    // Fast I/O class for competitive programming
    static class FastIO {
        BufferedReader br;
        StringTokenizer st;
        PrintWriter pw;

        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(System.out);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public void println(Object o) {
            pw.println(o);
        }

        public void close() {
            pw.flush();
            pw.close();
        }
    }
}