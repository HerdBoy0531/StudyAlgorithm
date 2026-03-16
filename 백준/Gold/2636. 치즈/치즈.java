import java.io.*;
import java.util.*;

public class Main {
	static int n, m, lastCheeze;
	static int[][] cheeze, melt;
	static boolean[][] visited1, visited2;
	
	static int[] dy = new int[] {0, 0, 1, -1};
	static int[] dx = new int[] {1, -1, 0, 0};
	
	static void meltBFS() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		visited1[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			for(int i = 0; i < 4; i++) {
				int cy = curY + dy[i];
				int cx = curX + dx[i];
				if(cy < 0 || cx < 0 || cy >= n || cx >= m) continue;
				if(visited1[cy][cx]) continue;
				if(cheeze[cy][cx] == 1) {
					visited1[cy][cx] = true;
					melt[cy][cx] = 1;
					continue;
				}
				q.offer(new int[] {cy, cx});
				visited1[cy][cx] = true;
			}
		}
	}
	
	static void lastBFS(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		melt[y][x] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			for(int i = 0; i < 4; i++) {
				int cy = curY + dy[i];
				int cx = curX + dx[i];
				if(cy < 0 || cx < 0 || cy >= n || cx >= m) continue;
				if(melt[cy][cx] == 0) continue;
				q.offer(new int[] {cy, cx});
				melt[cy][cx] = 0;
				lastCheeze += 1;
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
		
		
		visited2 = new boolean[n][m];
		boolean check = true;
		int meltCnt = 0;
		lastCheeze = 0;
		
		while(check) {
			boolean isCheeze = false;
			visited1 = new boolean[n][m];
			melt = new int[n][m];
			
			meltBFS();
			meltCnt += 1;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(melt[i][j] == 1) {
						cheeze[i][j] = 0;
					}
					if(cheeze[i][j] == 1) {
						isCheeze = true;
					}
				}
			}
			
			if(!isCheeze) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						if(melt[i][j] == 1) {
							lastCheeze += 1;
							lastBFS(i, j);
						}
					}
				}
				check = false;
			}
		}
		
		System.out.println(meltCnt);
		System.out.println(lastCheeze);
	}

}
