import java.io.*;

public class Main {
	static int[][] chess;
	static int n;
	static int cnt = 0;
	static int[] dy = new int[] {-1, -1, -1};
	static int[] dx = new int[] {0, -1, 1};
	
	static boolean isOK(int y, int x) {
		for(int i = 1; i < y + 1; i++) {
			for(int j = 0; j < 3; j++) {
				int cy = y + dy[j] * i;
				int cx = x + dx[j] * i;
				if(cy < 0 || cy >= n || cx < 0 || cx >= n) continue;
				if(chess[cy][cx] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void queen(int lev) {
		if(lev == n) {
			cnt++;
		}
		
		for(int i = 0; i < n; i++) {
			if(isOK(lev, i)) {
				chess[lev][i] = 1;
				queen(lev+1);
				chess[lev][i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		chess = new int[n][n];
		
		queen(0);
		
		System.out.println(cnt);
	}
}
