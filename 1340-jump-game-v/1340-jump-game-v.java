import java.util.*;

class Solution {
    static int n, d;
    static int[] arr;
    static int[] dp;

    static int dfs(int idx) {
        // 이미 계산한 경우
        if (dp[idx] != 0) {
            return dp[idx];
        }

        int best = 1;

        // 오른쪽 탐색
        for (int i = 1; i <= d; i++) {
            int next = idx + i;

            if (next >= n) break;

            if (arr[next] >= arr[idx]) break;

            best = Math.max(best, 1 + dfs(next));
        }

        // 왼쪽 탐색
        for (int i = 1; i <= d; i++) {
            int next = idx - i;

            if (next < 0) break;

            if (arr[next] >= arr[idx]) break;

            best = Math.max(best, 1 + dfs(next));
        }

        return dp[idx] = best;
    }

    public int maxJumps(int[] nums, int dis) {
        arr = nums;
        d = dis;
        n = nums.length;

        dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }

        return ans;
    }
}