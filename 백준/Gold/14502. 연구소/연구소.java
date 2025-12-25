import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static int[][] map;
	public static int[][] mapClone;
	public static int maxSaftyZone = Integer.MIN_VALUE;
	
	static class virus {
		int y;
		int x;
		
		public virus(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii = 0; ii < m; ii++) {
				map[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(maxSaftyZone);

	}
	
	public static void dfs(int wallCnt) {
		if(wallCnt == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int ii = 0 ; ii < m; ii++) {
				if(map[i][ii] == 0) {
					map[i][ii] = 1;
					dfs(wallCnt + 1);
					map[i][ii] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<virus> q = new LinkedList<virus>();
		int[] directY = new int[] {0, 0, 1, -1}; 
		int[] directX = new int[] {1, -1, 0, 0}; 
		for(int i = 0 ; i < n; i++) {
			for(int ii = 0; ii < m; ii++) {
				if(map[i][ii] == 2) {
					q.offer(new virus(i, ii));
				}
			}
		}
		
		mapClone = new int[n][m];
		
		for(int i = 0 ; i < n; i++) {
			mapClone[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
			virus v = q.poll();
			
			for(int i =0; i < 4; i++) {
				int dy = v.y + directY[i];
				int dx = v.x + directX[i];
				
				if(dy < 0 || dy >= n || dx < 0 || dx >= m) continue;
				if(mapClone[dy][dx] == 0) {
					mapClone[dy][dx] = 2;
					q.add(new virus(dy, dx));
				}
			}
		}
		
		findSafeZone(mapClone);
	}

	private static void findSafeZone(int[][] mapClone) {
		int safeZone = 0;
		for(int i = 0 ; i < n; i++) {
			for(int ii = 0; ii < m; ii++) {
				if(mapClone[i][ii] == 0) {
					safeZone++;
				}
			}
		}
		
		maxSaftyZone = Math.max(maxSaftyZone, safeZone);
		
	}
	
}
