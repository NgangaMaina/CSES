import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class MaximumSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader (new InputStreamReader(System.in));

        //Read the size of the array
        int n = Integer.parseInt(br.readLine().trim());

        //Read the array elements
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //Find the maximum subarray sum using Kadane's algorithm
        long maxSum = kadane(arr);

        //Print the result
        System.out.println(maxSum);
    }

    private static long kadane(int[] arr) {
        if(arr.length == 0) return 0;

        long currentSum = arr[0];
        long maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            //Either take the current element or extend the previous subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            //Update maximum sum if current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
