import java.util.*;
public class JosephusP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        FenwickTree ft = new FenwickTree(n);
        for(int i = 1; i <=n; i++){
            ft.update(i, 1);
        }
        StringBuilder sb = new StringBuilder();
        long remaining = n;
        long current_rank = 1;

        while (remaining > 0) {
            long temp = (current_rank - 1 + (long) k) % remaining;
            long target_t = temp + 1;
            int remove_pos = findPosition(ft, target_t, n);
            sb.append(remove_pos).append(" ");
            ft.update(remove_pos, -1);
            remaining--;
            if(remaining == 0) break;
            long target_c = target_t;
            long old_remaining = remaining + 1;
            long old_next_c = (target_c < old_remaining) ? target_c + 1 : 1;
            current_rank = (old_next_c > target_c) ? old_next_c - 1: old_next_c;
        }
        System.out.println(sb.toString().trim());
    }

    private static int findPosition(FenwickTree ft, long t, int n){
        int low = 1;
        int high = n;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (ft.prefix(mid) >= t){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int n) {
        this.n = n;
        tree = new int[n + 2];
    }
    public void update(int idx, int val){
        while(idx <= n){
            tree[idx] += val;
            idx += idx & -idx;
        }
    }

    public long prefix(int idx){
        long sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}
