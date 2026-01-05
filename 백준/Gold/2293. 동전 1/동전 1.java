import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[] coin = new int[n];
		int[] dp = new int[k + 1];
		
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k+1; j++) {
				if(j >= coin[i]) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		
		System.out.println(dp[k]);
		br.close();

	}

}