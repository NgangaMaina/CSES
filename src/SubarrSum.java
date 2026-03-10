import java.util.*;
import java.io.*;
public class SubarrSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;   //Current window's sum
        long count = 0; //Number of valid subarrays
        int left = 0;   //Starting pointer of the window

        //Expand right from 0 - n - 1
        for(int right = 0; right < n; right++) {
            sum += a[right];    //Add new element to sum

            //Shrink from left if sum excees x
            while(sum > x && left <= right) {
                sum -= a[left];
                left++;
            }

            if(sum == x){
                count++;
            }
        }
        System.out.println(count);
    }
}
