import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];

        int res = box();
        System.out.print(res);
        br.close();
    }

    private static int box() {
        dp[1] = 1;
        dp[2] = 3;

        if (N == 1) return dp[1];
        if (N == 2) return dp[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        return dp[N];
    }
}