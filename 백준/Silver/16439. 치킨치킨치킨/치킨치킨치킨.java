import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		int res = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = i+1; j < m; j++) {
				for(int k = j+1; k < m; k++) {
					int sum = 0;
					for(int p = 0; p < n; p++) {
						int best = Math.max(arr[p][i],
								   Math.max(arr[p][j], arr[p][k]));
						
						sum += best;
					}

					res = Math.max(res, sum);
				}
			}
		}
		
		System.out.println(res);
	}

}