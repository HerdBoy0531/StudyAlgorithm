import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] people = new int[n];
		int[] height = new int[n-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n-1; i++) {
			height[i] = people[i+1] - people[i];
		}
		
		Arrays.sort(height);
		
		int res = 0;
		for(int i = 0; i < n-k; i++) {
			res += height[i];
		}
		
		System.out.println(res);
		
		br.close();
	}

}