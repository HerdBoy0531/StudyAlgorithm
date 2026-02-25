import java.io.*;
import java.util.*;


public class Main {
	
	static int n, m;
	static int[][] cheeze;
	static boolean[][] visited;
	static int[][] visitedC;
	static int[] dy = new int[] {0, 0, 1, -1};
	static int[] dx = new int[] {1, -1, 0, 0};
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int cy = y + dy[i];
				int cx = x + dx[i];
				
				if(cy < 0 || cy >= n || cx < 0 || cx >=m) continue;
				if(cheeze[cy][cx] == 1) {
					visitedC[cy][cx] += 1; 
					continue;
				}
				if(!visited[cy][cx]) {
					visited[cy][cx] = true;
					q.offer(new int[] {cy, cx});
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheeze = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		boolean rotate = true;
		
		while(rotate) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(cheeze[i][j] == 1) {
						cnt+=1;
						break;
					}
					
				}
				if(cnt == 1) {
					break;
				}
			}
			if(cnt == 0) break;
			
			visited = new boolean[n][m];
			visitedC = new int[n][m];
			
			bfs();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(visitedC[i][j] >= 2) cheeze[i][j] = 0;
				}
			}
			
			ans += 1;
		}
		
		System.out.println(ans);
	}

}