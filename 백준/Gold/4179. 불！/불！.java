import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r][c];
		boolean[][] visited = new boolean[r][c];
		
		Queue<int[]> fire = new ArrayDeque<>();
		Queue<int[]> jihoon = new ArrayDeque<>();
		
		for(int i = 0; i < r; i++) {
			String arr = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = arr.charAt(j);
				
				if(map[i][j] == 'J') {
					jihoon.offer(new int[] {i, j, 0});
					visited[i][j] = true;
					map[i][j] = '.';
				}
				
				if(map[i][j] == 'F') {
					fire.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		while(!jihoon.isEmpty()) {
			
			int fireSize = fire.size();
			for(int f = 0; f < fireSize; f++) {
				int[] cur = fire.poll();
				int curY = cur[0];
				int curX = cur[1];
				
				for(int i = 0; i < 4; i++) {
					int cy = curY + dy[i];
					int cx = curX + dx[i];
					
					if(cy < 0 || cx < 0 || cy >= r || cx >= c) continue;
					if(map[cy][cx] == '#' || map[cy][cx] == 'F') continue;
					
					map[cy][cx] = 'F';
					fire.offer(new int[] {cy, cx});
				}
			}
			
			int jihoonSize = jihoon.size();
			for(int j = 0; j < jihoonSize; j++) {
				int[] cur = jihoon.poll();
				int curY = cur[0];
				int curX = cur[1];
				int cnt = cur[2];
				
				if(curY == 0 || curX == 0 || curY == r - 1 || curX == c - 1) {
					System.out.println(cnt + 1);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int cy = curY + dy[i];
					int cx = curX + dx[i];
					
					if(cy < 0 || cx < 0 || cy >= r || cx >= c) continue;
					if(map[cy][cx] == '#' || map[cy][cx] == 'F' || visited[cy][cx]) continue;
					
					visited[cy][cx] = true;
					jihoon.offer(new int[] {cy, cx, cnt + 1});
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
}