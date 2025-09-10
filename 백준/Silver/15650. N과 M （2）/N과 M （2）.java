import java.io.*;
import java.util.*;

public class Main{
	static int[] arr;
	static int N, M;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1, 0);
		br.readLine();
	}
	
	static void dfs(int at, int lev) {
		if(lev == M) {
			for( int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = at; i <= N; i++) {
			arr[lev] = i;
			dfs( i+1, lev+1);
		}
	}

}
