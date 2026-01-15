import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int maxNum = Integer.MIN_VALUE;
	static int[] directY = new int[] {1, -1, 0, 0};
	static int[] directX = new int[] {0, 0, 1, -1};
	
	public static void dfs(int y, int x, int depth, int plus) {
		if (depth == 4) {
			maxNum = Math.max(maxNum, plus);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int dy = directY[i] + y;
			int dx = directX[i] + x;
			
			if(dy < 0 || dy >= n || dx < 0 || dx >= m) continue;
			if(visited[dy][dx]) continue;
			
			visited[dy][dx] = true;
			dfs(dy, dx, depth+1, plus+arr[dy][dx]);
			visited[dy][dx] = false;
		}
		
	}
	
	public static void checkT(int y, int x) {
	    int center = arr[y][x];
	    for (int i = 0; i < 4; i++) {
	        int plus = center;
	        boolean ok = true;
	        for (int j = 0; j < 3; j++) {
	            int d = (i + j) % 4;
	            int dy = y + directY[d];
	            int dx = x + directX[d];
	            if(dy < 0 || dy >= n || dx < 0 || dx >= m) {
	                ok = false;
	                break;
	            }
	            plus += arr[dy][dx];
	        }
	        if (ok) maxNum = Math.max(maxNum, plus);
	    }
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, 0);
				visited[i][j] = false;
				
				checkT(i, j);
			}
		}
		
		System.out.println(maxNum);
		
		br.close();

	}

}