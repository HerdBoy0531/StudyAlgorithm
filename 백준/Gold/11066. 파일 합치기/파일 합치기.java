import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[k + 1];
            int[] sum = new int[k + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            int[][] dp = new int[k + 1][k + 1];

            for (int len = 2; len <= k; len++) {
                for (int i = 1; i <= k - len + 1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int m = i; m < j; m++) {
                        dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][m] + dp[m + 1][j] + (sum[j] - sum[i - 1])
                        );
                    }
                }
            }

            sb.append(dp[1][k]).append("\n");
        }

        System.out.print(sb);
    }
}