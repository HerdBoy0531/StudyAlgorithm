import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1;
		while(true) {
			int[] B = new int[n];
			
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				for(int j = i+1; j < n; j++) {
					if(j >= n) {
						B[j-1] = 0;
						break;
					}
					if(A[i] < A[j]) {
						cnt += 1;
					}
				}
				B[i] = cnt;
			}
			
			boolean check = true;
			for(int i = 0; i < n; i++) {
				if(A[i] != B[i]) {
					check = false;
				}
			}
			
			if(check) {
				break;
			}
			
			A = B.clone();
			ans += 1;
		}

		System.out.println(ans);
		
	}

}