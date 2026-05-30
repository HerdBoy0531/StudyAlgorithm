import java.util.*;

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;

        for (int[] q : queries) {
            if (q[0] == 1) {
                maxX = Math.max(maxX, q[1]);
            } else {
                maxX = Math.max(maxX, q[1]);
            }
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(maxX + 2);

        Integer prev = null;
        for (int pos : obstacles) {
            if (prev != null) {
                seg.update(pos, pos - prev);
            }
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                Integer obstacle = obstacles.floor(x);

                int best = seg.query(0, obstacle);

                int tail = x - obstacle;

                ans.add(Math.max(best, tail) >= sz);

            } else {
                int pos = q[1];

                Integer left = obstacles.lower(pos);
                Integer right = obstacles.higher(pos);

                obstacles.remove(pos);

                if (right != null) {
                    seg.update(right, right - left);
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int size) {
            n = 1;
            while (n < size) n <<= 1;
            tree = new int[n * 2];
        }

        void update(int idx, int value) {
            idx += n;
            tree[idx] = value;

            while (idx > 1) {
                idx >>= 1;
                tree[idx] = Math.max(tree[idx * 2], tree[idx * 2 + 1]);
            }
        }

        int query(int left, int right) {
            left += n;
            right += n;

            int res = 0;

            while (left <= right) {
                if ((left & 1) == 1) {
                    res = Math.max(res, tree[left++]);
                }

                if ((right & 1) == 0) {
                    res = Math.max(res, tree[right--]);
                }

                left >>= 1;
                right >>= 1;
            }

            return res;
        }
    }
}