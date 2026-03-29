import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] r = new int[n];
		int[] c = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[n][n];
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= n-i; j++) {
				int k = j + i - 1;
				dp[j][k] = Long.MAX_VALUE;
				
				for(int l = j; l < k; l++) {
					long cost = dp[j][l] + dp[l+1][k] + (long)r[j] * c[l] * c[k];
					dp[j][k] = Math.min(dp[j][k], cost);
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

}