import java.util.*;

public class FourSum {
    static class Node implements Comparable<Node> {
        long val;
        int idx;

        Node(long v, int i) {
            val = v;
            idx = i;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long target = sc.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(a[i], i + 1); // 1-based
        }
        Arrays.sort(nodes);

        boolean found = false;
        outer:
        for (int i = 0; i < n - 3; i++) {
            if (nodes[i].val + nodes[n-3].val + nodes[n-2].val + nodes[n-1].val < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                long sum2 = nodes[i].val + nodes[j].val;
                if (sum2 + nodes[n-2].val + nodes[n-1].val < target) {
                    continue;
                }


                if (sum2 + nodes[j+1].val + nodes[j+2].val > target) {
                    break;
                }

                long need = target - sum2;
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sumLR = nodes[left].val + nodes[right].val;

                    if (sumLR == need) {
                        // Found!
                        int[] pos = {
                                nodes[i].idx,
                                nodes[j].idx,
                                nodes[left].idx,
                                nodes[right].idx
                        };
                        Arrays.sort(pos);
                        for (int p : pos) {
                            System.out.print(p + " ");
                        }
                        System.out.println();
                        found = true;
                        break outer;
                    } else if (sumLR < need) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}