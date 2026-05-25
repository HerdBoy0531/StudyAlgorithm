class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        int[] prefix = new int[n + 1];

        dp[0] = true;
        prefix[1] = 1;

        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == '0') {

                int left = Math.max(0, i - maxJump);
                int right = i - minJump;

                if (right >= 0) {
                    int reachable =
                        prefix[right + 1] - prefix[left];

                    if (reachable > 0) {
                        dp[i] = true;
                    }
                }
            }

            prefix[i + 1] =
                prefix[i] + (dp[i] ? 1 : 0);
        }

        return dp[n - 1];
    }
}