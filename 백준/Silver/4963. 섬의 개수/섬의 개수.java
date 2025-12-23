import java.io.*;
import java.util.*;

public class Main {
	public static int h, w;
	public static int[][] arr;
	
	public static void bfs(int y, int x) {
		arr[y][x] = 0;
		
		int[] directY = new int[] {0, 0, 1, -1, 1, 1, -1, -1}; 
		int[] directX = new int[] {1, -1, 0, 0, -1, 1, 1, -1}; 
		
		Deque<int[]> q = new ArrayDeque<>();
		q.offerLast(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int i = 0 ; i < 8; i++) {
				int dy = directY[i] + cur[0];
				int dx = directX[i] + cur[1];
				if(dy < 0 || dy >= h || dx < 0 || dx >= w ) continue;
				if(arr[dy][dx] == 1) {
					arr[dy][dx] = 0;
					q.offerLast(new int[] {dy, dx});
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean  finish = true;
		StringTokenizer st;
		while(finish) {
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			if(w == 0 && h == 0) break;
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int ii = 0 ; ii < w; ii++) {
					arr[i][ii] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			// 섬 찾기
			for(int i = 0; i < h; i++) {
				for(int ii = 0 ; ii < w; ii++) {
					if(arr[i][ii] == 1) {
						count++;
						bfs(i, ii);
					}
				}
			}
			
			System.out.println(count);
		}
		
		
		br.close();
	}

}