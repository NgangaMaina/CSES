import java.io.*;
import java.util.*;

public class OperationRounds {
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        pos = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos[arr[i]] = i;
        }

        int rounds = 1;
        for (int i = 1; i < n; i++) {
            if (pos[i] > pos[i + 1]) rounds++;
        }

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (a == b) {
                sb.append(rounds).append("\n");
                continue;
            }

            int x = arr[a], y = arr[b];
            int[] vals = new int[]{x - 1, x, y - 1, y};
            boolean[] seen = new boolean[n + 2];

            for (int v : vals) {
                if (v >= 1 && v < n && !seen[v]) {
                    if (pos[v] > pos[v + 1]) rounds--;
                    seen[v] = true;
                }
            }

            // Swap
            arr[a] = y;
            arr[b] = x;
            int temp = pos[x];
            pos[x] = pos[y];
            pos[y] = temp;

            Arrays.fill(seen, false); // reuse same array
            for (int v : vals) {
                if (v >= 1 && v < n && !seen[v]) {
                    if (pos[v] > pos[v + 1]) rounds++;
                    seen[v] = true;
                }
            }

            sb.append(rounds).append("\n");
        }

        System.out.print(sb);
    }
}
