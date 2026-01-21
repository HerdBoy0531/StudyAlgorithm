import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp, cost;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int red = 0;
		int green = 1;
		int blue = 2;
		
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n][3];
		cost = new int[n][3];
		
		
		for(int i = 0; i < n ;i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
        for (int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 결과
        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(result);
	}


}