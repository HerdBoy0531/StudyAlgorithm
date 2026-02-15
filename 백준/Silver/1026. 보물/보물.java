import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		int[] B = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i < B.length / 2; i++){
		    int tmp = B[i];
		    B[i] = B[B.length - 1 - i];
		    B[B.length - 1 - i] = tmp;
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans += A[i] * B[i];
		}
		
		System.out.println(ans);
	}

}