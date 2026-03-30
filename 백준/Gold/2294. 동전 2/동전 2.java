import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		int[] dp = new int[m+1];
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < n; i++) {
			int coin = coins[i];
			for(int j = coin; j <= m; j++) {
				if(dp[j - coin] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - coin] + 1);
				}
			}
		}
		
		if(dp[m] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[m]);
		}
	}

}