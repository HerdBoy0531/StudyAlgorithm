import java.io.*;
import java.util.*;

public class Main {
	static int h, w;
	static char[][] map;
	static boolean[][] visited;
	static int[] treaOne = new int[2];
	static int[] treaTwo = new int[2];
	static int maxSearch = Integer.MIN_VALUE;
	
	static void searchMap(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		int len = 0;
		q.offer(new int[] {y, x, len});
		
		visited = new boolean[h][w];
		visited[y][x] = true;
		
		int[] directY = new int[] {0, 0, 1, -1};
		int[] directX = new int[] {1, -1, 0, 0};
		
		while(!q.isEmpty()) {			
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			int clen = cur[2];
			
			if(clen > maxSearch) {
				maxSearch = clen;
				treaOne[0] = y;
				treaOne[1] = x;
				treaTwo[0] = cy;
				treaTwo[1] = cx;
			}

			for(int i = 0; i < 4; i++) {
				int dy = directY[i] + cy;
				int dx = directX[i] + cx;
				if(dy < 0 || dx < 0 || dy >= h || dx >= w) continue;
				if(map[dy][dx] == 'W' || visited[dy][dx]) continue;
				q.offer(new int[] {dy, dx, clen+1});
				visited[dy][dx] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		h = Integer.parseInt(arr[0]);
		w = Integer.parseInt(arr[1]);
		map = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			String land = br.readLine();
			for(int j = 0; j < w; j++) {
				map[i][j] = land.charAt(j);
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 'L') {
					searchMap(i, j);
				}
			}
		}
		
		System.out.println(maxSearch);
	}

}