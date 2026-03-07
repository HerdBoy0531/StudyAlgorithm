import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[] visited;
	static int start, end;
	static boolean res;
	
	static void dfs(int cur) {
		if(cur == end) {
			res = true;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(map[cur][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
			if(res) return;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		StringTokenizer st;
		
		for(int i = 0; i < n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] route = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			route[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		res = true;
		
		for(int i = 0; i < m-1; i++) {
			start = route[i];
			end = route[i+1];
			
			visited = new boolean[n];
			visited[start] = true;
			
			boolean check = false;
			res = false;
			
			dfs(start);
			
			if(!res) {
				check = true;
				break;
			}
		}
		
		if(res) System.out.println("YES");
		else System.out.println("NO");
	}
}