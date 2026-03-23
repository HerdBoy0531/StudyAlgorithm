import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		boolean[][][] visited = new boolean[k+1][n][m];
		
		for(int i = 0; i <n ; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = (int)str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 0});
		visited[0][0][0] = true;
		
		int[] dy = new int[] {0, 0, 1, -1};
		int[] dx = new int[] {1, -1, 0, 0};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int wall = cur[2];
			int cnt = cur[3];
			
			if(curY == n-1 && curX == m-1) {
				System.out.println(cnt+1);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int cy = curY + dy[i];
				int cx = curX + dx[i];
				
				if(cy < 0 || cx < 0 || cy >= n || cx >= m) continue;
				if(map[cy][cx] == 1 && wall < k && !visited[wall+1][cy][cx]) {
					visited[wall+1][cy][cx] = true;
					q.offer(new int[] {cy, cx, wall+1, cnt+1});
				}
				if(map[cy][cx] == 0 && !visited[wall][cy][cx]) {

					visited[wall][cy][cx] = true;
					q.offer(new int[] {cy, cx, wall, cnt+1});
				}
			}
		}
		
		System.out.println(-1);

	}

}