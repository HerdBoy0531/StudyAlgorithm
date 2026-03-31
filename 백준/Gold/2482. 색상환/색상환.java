import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[k+1][n+1];
		
		Arrays.fill(dp[0], 0);
		
		for(int i = 0; i <= n; i++) {
			dp[1][i] = i;
		}
		
		int INF = 1000000003;
		if(k >= 2) {
			for(int i = 2; i <= k; i++) {
				for(int j = 4; j <= n; j++) {
					if(j / i < 2) dp[i][j] = 0;
					else {
						if(j / i == 2 && j % i == 0) dp[i][j] = 2;
						else if(j / i == 2 && j % i == 1) dp[i][j] = j;
						else {
							dp[i][j] = (dp[i-1][j-2] + dp[i][j-1]) % INF;
						}
					}
				}
			}
		}
		
		System.out.println(dp[k][n]);
	}

}
