import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        long maxT = 0;

        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(st.nextToken());
            sum += t;
            if (t > maxT) maxT = t;
        }

        long ans = Math.max(sum, maxT << 1);
        System.out.println(ans);
    }
}