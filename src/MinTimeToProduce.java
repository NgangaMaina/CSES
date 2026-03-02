import java.util.*;
public class MinTimeToProduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long t = sc.nextLong();
        long[] k = new long[(int) n];
        long maxK = 0;
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
            if (k[i] > maxK) maxK = k[i];
        }
        sc.close();

        //Binary search bounds
        long low = 0;
        long high = t * maxK; //Max possible time

        while (low < high) {
            long mid = low +  (high - low)/2;
            if(canProduce(mid, k, t)) {
                high = mid;
            } else{
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    private static boolean canProduce(long time, long[] k, long target) {
        long total = 0;
        for(long ki : k) {
            long contrib = time/ki;
            if(contrib >= target - total) {
                return true; //Will exceed or meet target.
            }
            total += contrib;
        }
        return false;
    }
}
