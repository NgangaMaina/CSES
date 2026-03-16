import java.io.*;
import java.util.*;

public class ArrDiv {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        long maxElement = 0;
        long totalSum = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
            maxElement = Math.max(maxElement, arr[i]);
            totalSum += arr[i];
        }

        //Binary search on the answer
        long low = maxElement;
        long high = totalSum;

        while(low < high) {
            long mid = low + (high - low) / 2;
            if(canPartition(arr, mid, k)) {
                //Try making max even smaller
                high = mid;
            }else {
                //Need larger  max
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    //Greedy Check
    private static boolean canPartition(long[] arr, long maxSum, int k) {
        long currentSum = 0;
        int subarraysUsed = 1;

        for(long num : arr){
            if(currentSum + num > maxSum){
                subarraysUsed++;
                currentSum = num;

                if(subarraysUsed > k){
                    return false;
                }
            }else{
                currentSum += num;
            }
        }
        return true;
    }
}
