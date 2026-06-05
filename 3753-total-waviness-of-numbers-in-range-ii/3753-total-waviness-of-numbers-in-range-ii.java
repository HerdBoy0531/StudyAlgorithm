import java.util.*;

class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    String num;
    Pair[][][][][] dp;

    Pair dfs(int pos, int prev2, int prev1, int tight, int started) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0
                && dp[pos][prev2][prev1][0][started] != null) {
            return dp[pos][prev2][prev1][0][started];
        }

        int limit =
                (tight == 1)
                        ? num.charAt(pos) - '0'
                        : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight =
                    (tight == 1 && digit == limit)
                            ? 1
                            : 0;

            int nextStarted =
                    (started == 1 || digit != 0)
                            ? 1
                            : 0;

            int add = 0;

            if (nextStarted == 1
                    && prev2 != 10
                    && prev1 != 10) {

                if (prev1 > prev2
                        && prev1 > digit) {
                    add++;
                }

                if (prev1 < prev2
                        && prev1 < digit) {
                    add++;
                }
            }

            int nextPrev2 = prev2;
            int nextPrev1 = prev1;

            if (nextStarted == 0) {

                nextPrev2 = 10;
                nextPrev1 = 10;

            } else {

                if (prev1 == 10) {

                    nextPrev2 = 10;
                    nextPrev1 = digit;

                } else if (prev2 == 10) {

                    nextPrev2 = prev1;
                    nextPrev1 = digit;

                } else {

                    nextPrev2 = prev1;
                    nextPrev1 = digit;
                }
            }

            Pair child = dfs(
                    pos + 1,
                    nextPrev2,
                    nextPrev1,
                    nextTight,
                    nextStarted
            );

            totalCount += child.count;

            totalWaviness +=
                    child.waviness
                            + child.count * add;
        }

        Pair res =
                new Pair(totalCount, totalWaviness);

        if (tight == 0) {
            dp[pos][prev2][prev1][0][started] = res;
        }

        return res;
    }

    long solve(long n) {

        if (n < 0) return 0;

        num = String.valueOf(n);

        dp = new Pair[20][11][11][2][2];

        Pair res = dfs(
                0,
                10,
                10,
                1,
                0
        );

        return res.waviness;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2)
                - solve(num1 - 1);
    }
}