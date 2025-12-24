import java.io.*;
import java.util.*;

public class Main {
	static int h, w;
	static int[][] arr;
	
	public static int bfs(int y, int x) {
		int picCnt = 1;
		int[] directY = new int[] {0, 0, 1, -1};
		int[] directX = new int[] {1, -1, 0, 0};
		arr[y][x] = 0;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offerLast(new int[] {y, x});
				
		while(!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int curY = cur[0];
			int curX = cur[1];
			
			for(int i = 0 ; i < 4; i++) {
				int dy = curY + directY[i];
				int dx = curX + directX[i];
				if(dy >= h || dy < 0 || dx >= w || dx < 0) continue;
				if(arr[dy][dx] == 1) {
					arr[dy][dx] = 0;
					picCnt++;
					dq.offerLast(new int[] {dy, dx});
				}
			}
		}
		
		
		return picCnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		int count = 0;
		int maxPic = 0;
		int pics = 0;
		
		for(int i = 0 ; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii = 0; ii < w; ii++) {
				arr[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < h; i++) {
			for(int ii = 0; ii < w; ii++) {
				if(arr[i][ii] == 1) {
					count++;
					pics = bfs(i, ii);
					maxPic = Math.max(maxPic, pics);
				}
			}
		}
		System.out.println(count);
		System.out.println(maxPic);

	}

}