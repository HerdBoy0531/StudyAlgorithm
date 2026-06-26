class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> rank = new HashMap<>();
        int idx = 1;

        for (long v : sorted) {
            if (!rank.containsKey(v)) {
                rank.put(v, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx);

        long answer = 0;

        for (long cur : prefix) {
            int r = rank.get(cur);
            answer += bit.query(r - 1);
            bit.update(r, 1);
        }

        return answer;
    }

    static class Fenwick {
        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void update(int idx, long val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;

            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }

            return sum;
        }
    }
}