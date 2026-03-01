import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		int[] dy = new int[n];
		int[] dx = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dy[i] = Integer.parseInt(st.nextToken());
			dx[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] visited = new boolean[r][c];
		Queue<int[]> q = new ArrayDeque<>();
		
		int cnt = 0;
		
		for(int i = 0; i < c; i++) {
			if(map[0][i] == 1) {
				visited[0][i] = true;
				q.offer(new int[] {0, i, 0});
			}
		}

		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cCnt = cur[2];
			
			if(y == r-1) {
				cnt = cCnt;
				break;
			}
			
			for(int i = 0; i < n; i++) {
				int cy = y + dy[i];
				int cx = x + dx[i];
				
				if(cy < 0 || cy >= r || cx < 0 || cx >= c) continue;
				if(!visited[cy][cx] && map[cy][cx] == 1) {
					q.offer(new int[] {cy, cx, cCnt+1});
					visited[cy][cx] = true;
				}
			}
		}
		if(cnt == 0) {
			cnt = -1;
		}
		System.out.println(cnt);
	}

}