import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			if(a == 1) {
				arr[b] = c;

			} else if(a == 2) {
				for(int j = b; j <= c; j++) {
					arr[j] = Math.abs(arr[j] - 1);
				}
			} else if(a == 3) {
				for(int j = b; j <= c; j++) {
					arr[j] = 0;
				}
			} else if(a == 4) {
				for(int j = b; j <= c; j++) {
					arr[j] = 1;
				}
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
		
		
		br.close();
	}

}