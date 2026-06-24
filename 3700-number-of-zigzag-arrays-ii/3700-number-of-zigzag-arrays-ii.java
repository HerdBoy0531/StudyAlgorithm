import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        int size = 2 * m;

        long[] base = new long[size];

        // length = 2 상태
        for (int i = 0; i < m; i++) {
            base[i] = i;             // up[i] : prev < i
            base[m + i] = m - 1 - i; // down[i] : prev > i
        }

        if (n == 2) {
            long ans = 0;
            for (long v : base) {
                ans = (ans + v) % MOD;
            }
            return (int) ans;
        }

        long[][] trans = new long[size][size];

        for (int i = 0; i < m; i++) {

            // newUp[i] = sum of down[j], j < i
            for (int j = 0; j < i; j++) {
                trans[i][m + j] = 1;
            }

            // newDown[i] = sum of up[j], j > i
            for (int j = i + 1; j < m; j++) {
                trans[m + i][j] = 1;
            }
        }

        long[][] power = matrixPow(trans, n - 2);
        long[] result = multiply(power, base);

        long answer = 0;
        for (long v : result) {
            answer = (answer + v) % MOD;
        }

        return (int) answer;
    }

    private long[][] matrixPow(long[][] matrix, long exp) {
        int n = matrix.length;

        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, matrix);
            }

            matrix = multiply(matrix, matrix);
            exp >>= 1;
        }

        return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private long[] multiply(long[][] matrix, long[] vector) {
        int n = matrix.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;

                sum = (sum + matrix[i][j] * vector[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }
}