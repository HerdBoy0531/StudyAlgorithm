import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int[][][] dp = new int[N][N][K + 1];

        for (int l = 0; l < N; l++) {
            for (int r = 0; r < N; r++) {
                for (int k = 0; k <= K; k++) {
                    dp[l][r][k] = INF;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= K; k++) {
                dp[i][i][k] = 1;
            }
        }

        for (int len = 2; len <= N; len++) {
            for (int l = 0; l + len - 1 < N; l++) {

                int r = l + len - 1;

                for (int k = 0; k <= K; k++) {

                    dp[l][r][k] = len;

                    for (int m = l; m < r; m++) {
                        for (int k1 = 0; k1 <= k; k1++) {
                            int k2 = k - k1;

                            dp[l][r][k] = Math.min(dp[l][r][k],
                                    dp[l][m][k1] + dp[m + 1][r][k2]);
                        }
                    }

                    if (k > 0) {
                        for (int i = l; i <= r; i++) {
                            for (int j = i + 1; j <= r; j++) {

                                if (s.charAt(i) == s.charAt(j) && s.charAt(i) != 'X') {

                                    for (int k1 = 0; k1 <= k - 1; k1++) {
                                        int k2 = (k - 1) - k1;

                                        int left = (i > l) ? dp[l][i - 1][k1] : 0;
                                        int right = (j < r) ? dp[j + 1][r][k2] : 0;

                                        dp[l][r][k] = Math.min(dp[l][r][k],
                                                left + right);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = INF;
        for (int k = 0; k <= K; k++) {
            ans = Math.min(ans, dp[0][N - 1][k]);
        }

        System.out.println(ans);
    }
}