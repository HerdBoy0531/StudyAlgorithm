import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[][] colorO, colorX;
	public static Deque<int[]> dq;
	
	public static void colorOBfs(int y, int x) {
		char color = colorO[y][x];
		colorO[y][x] = 'x';
		int[] directY = new int[] { 0, 0, 1, -1};
		int[] directX = new int[] { 1, -1, 0, 0};
		
		dq = new ArrayDeque<>();
		dq.offerFirst(new int[] {y, x});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.pollLast();
			int curY = cur[0];
			int curX = cur[1];
			for(int i = 0; i < 4; i++) {
				int dy = directY[i] + curY;
				int dx = directX[i] + curX;
				if(dy < 0 || dx < 0 || dy >= N || dx >= N) continue;
				if(colorO[dy][dx] == color) {
					dq.offerFirst(new int[] {dy, dx});
					colorO[dy][dx] = 'x';
				}
			}
		}
	}

	public static void colorXBfs(int y, int x) {
		char color = colorX[y][x];
		colorX[y][x] = 'x';
		int[] directY = new int[] { 0, 0, 1, -1};
		int[] directX = new int[] { 1, -1, 0, 0};
		
		dq = new ArrayDeque<>();
		dq.offerFirst(new int[] {y, x});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.pollLast();
			int curY = cur[0];
			int curX = cur[1];
			for(int i = 0; i < 4; i++) {
				int dy = directY[i] + curY;
				int dx = directX[i] + curX;
				if(dy < 0 || dx < 0 || dy >= N || dx >= N) continue;
				if(colorX[dy][dx] == color) {
					dq.offerFirst(new int[] {dy, dx});
					colorX[dy][dx] = 'x';
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		char color;
		N = Integer.parseInt(br.readLine());
		colorO = new char[N][N];
		colorX = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			st = br.readLine();
			for(int ii = 0; ii < N; ii++) {
				color = st.charAt(ii);
				if(color == 'G') {
					colorX[i][ii] = 'R';
					colorO[i][ii] = color;
				} else {
					colorX[i][ii] = color;
					colorO[i][ii] = color;
				}
			}
		}
				
		int colorOCnt = 0;
		int colorXCnt = 0;
		
		// 색약이 아닌 사람
		for(int i = 0; i < N; i++) {
			for(int ii = 0; ii < N; ii++) {
				if(colorO[i][ii] != 'x') {
					colorOBfs(i, ii);
					colorOCnt++;
				}
				if(colorX[i][ii] != 'x') {
					colorXBfs(i, ii);
					colorXCnt++;
				}
			}
		}
		System.out.println(colorOCnt+" "+colorXCnt);
	}

}