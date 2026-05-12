import java.util.*;

class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int[] dp = new int[n];
        dp[0] = tasks[0][1];

        int remain = tasks[0][1] - tasks[0][0];
        for(int i = 1; i < n; i++) {
            if(remain >= tasks[i][1]) {
                remain -= tasks[i][0];
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + tasks[i][1] - remain;
                remain = tasks[i][1] - tasks[i][0];
            }

            
        }

        return dp[n-1];
    }
}