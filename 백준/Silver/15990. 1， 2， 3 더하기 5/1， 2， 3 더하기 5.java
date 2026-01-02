import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int maxN = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxN = Math.max(arr[i], maxN);
		}
		
		long[][] dp = new long[maxN+1][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		long MOD = 1000000009;
		for(int i = 4; i < (maxN+1); i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
		}
		
		long res;
		for(int i = 0; i < N; i++) {
			res = 0;
			for(int ii = 1; ii < 4; ii++) {
				res = (res + dp[arr[i]][ii]) % MOD;
			}
			System.out.println(res);
		}

	}

}