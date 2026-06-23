class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixDown = new long[m];
            long[] suffixUp = new long[m];

            prefixDown[0] = down[0];
            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
            }

            suffixUp[m - 1] = up[m - 1];
            for (int i = m - 2; i >= 0; i--) {
                suffixUp[i] = (suffixUp[i + 1] + up[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int i = 0; i < m; i++) {

                // prev < i
                if (i > 0) {
                    newUp[i] = prefixDown[i - 1];
                }

                // prev > i
                if (i < m - 1) {
                    newDown[i] = suffixUp[i + 1];
                }
            }

            up = newUp;
            down = newDown;
        }

        long answer = 0;

        if (n == 2) {
            for (int i = 0; i < m; i++) {
                answer = (answer + up[i] + down[i]) % MOD;
            }
            return (int) answer;
        }

        for (int i = 0; i < m; i++) {
            answer = (answer + up[i] + down[i]) % MOD;
        }

        return (int) answer;
    }
}