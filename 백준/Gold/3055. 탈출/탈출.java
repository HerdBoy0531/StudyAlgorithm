import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		Queue<int[]> water = new ArrayDeque<>();		
		Queue<int[]> hedge = new ArrayDeque<>();	
		boolean[][] visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					hedge.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				} else if(map[i][j] == '*') {
					water.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dy = new int[] {0, 0, 1, -1};
		int[] dx = new int[] {1, -1, 0, 0};
		
		while(!hedge.isEmpty()) {
			int size = water.size();
			for(int i = 0; i < size; i++) {
				int[] cur = water.poll();
				int cy = cur[0];
				int cx = cur[1];
				for(int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
					if(map[ny][nx] == '*' || map[ny][nx] == 'D' || map[ny][nx] == 'X') continue;
					map[ny][nx] = '*';
					water.offer(new int[] {ny, nx});
				}
			}
			
			size = hedge.size();
			for(int i = 0; i < size; i++) {
				int[] cur = hedge.poll();
				int cy = cur[0];
				int cx = cur[1];
				int cnt = cur[2];
				for(int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
					if(visited[ny][nx] || map[ny][nx] == '*' || map[ny][nx] == 'X') continue;
					if(map[ny][nx] == 'D') {
						System.out.println(cnt+1);
						return;
					}
					visited[ny][nx] = true;
					hedge.offer(new int[] {ny, nx, cnt+1});
				}
			}
		}
		
		System.out.println("KAKTUS");

	}

}