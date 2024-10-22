/*
* Finding out the number in row y and column x from
* a number spiral.
* first input line is the number of tests.
* t number of lines follow containing y and x
* */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);
            long result;

            if (y >= x) {
                if (y % 2 == 1) {
                    result = (y - 1) * (y - 1) + x;
                } else {
                    result = y * y - x + 1;
                }
            } else {
                if (x % 2 == 1) {
                    result = x * x - y + 1;
                } else {
                    result = (x - 1) * (x - 1) + y;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
