import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[h][w];
		boolean[][][] visited = new boolean[k+1][h][w];
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0][0] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 0});
		
		int[] dy = new int[] {0, 0, 1, -1};
		int[] dx = new int[] {1, -1, 0, 0};
		
		int[] hy = new int[] {-1, -2, -2, -1, 1, 1, 2, 2};
		int[] hx = new int[] {-2, -1, 1, 2, -2, 2, -1, 1};
		
		if(h == 1 && w == 1) {
		    System.out.println(0);
		    return;
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int horse = cur[2];
			int cnt = cur[3];
			
			if(horse != k) {
				for(int i = 0; i < 8; i++) {
					int cy = curY + hy[i];
					int cx = curX + hx[i];
					if(cy < 0 || cx < 0 || cx >= w || cy >= h) continue;
					if(visited[horse+1][cy][cx] || map[cy][cx] == 1) continue;
					if(cy == h - 1 && cx == w - 1) {
						System.out.println(cnt+1);
						return;
					}
					q.offer(new int[] {cy, cx, horse + 1, cnt + 1});
					visited[horse+1][cy][cx] = true;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int cy = curY + dy[i];
				int cx = curX + dx[i];
				if(cy < 0 || cx < 0 || cx >= w || cy >= h) continue;
				if(visited[horse][cy][cx] || map[cy][cx] == 1) continue;
				if(cy == h - 1 && cx == w - 1) {
					System.out.println(cnt+1);
					return;
				}
				q.offer(new int[] {cy, cx, horse, cnt + 1});
				visited[horse][cy][cx] = true;
			}
			
		}
		
		System.out.println(-1);

	}

}