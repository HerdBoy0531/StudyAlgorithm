import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[N];
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
		    dp[i] = 1;
		    for (int j = 0; j < i; j++) {
		        if (arr[j] > arr[i]) {
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }
		    }
		}
		
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.print(N - maxLen);
		
	}

}