import java.util.*;
import java.io.*;

public class MaxSubArrSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken(); int n = (int) st.nval;
        st.nextToken(); int a = (int) st.nval;
        st.nextToken(); int b = (int) st.nval;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            prefix[i + 1] = prefix[i] + (long) st.nval;
        }

        long ans = Long.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            int addIdx = r + 1 - a;
            if (addIdx >= 0) {
                while (!dq.isEmpty() && prefix[addIdx] <= prefix[dq.peekLast()])
                    dq.pollLast();
                dq.addLast(addIdx);
            }

            while (!dq.isEmpty() && dq.peekFirst() < r + 1 - b)
                dq.pollFirst();

            if (!dq.isEmpty())
                ans = Math.max(ans, prefix[r + 1] - prefix[dq.peekFirst()]);
        }

        System.out.println(ans);
    }
}