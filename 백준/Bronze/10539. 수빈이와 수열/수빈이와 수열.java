import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		
		for(int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		A[0] = B[0];
		int cnt = A[0];
		if(n > 0) {
			for(int i = 1; i < n; i++) {
				A[i] = (B[i] * (i+1)) - cnt;
				cnt += A[i];
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.printf(A[i] + " ");
		}
		

	}

}