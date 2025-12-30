import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int[] arr = new int[tc];
		int maxN = 0;
		
		for(int i = 0; i < tc; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxN = Math.max(arr[i], maxN);
		}
		
		long[] dp = new long[maxN+1];
		
		dp[1] = 1;
		if(maxN >= 2) dp[2] = 2;
		if(maxN >= 3) dp[3] = 4;
		
		for(int i = 4; i <= maxN; i++) {
			dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;;
		}
		
		for(int i : arr) {
			sb.append(dp[i]).append("\n");
		}
		
		System.out.print(sb);

	}

}