import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		char[][] miro = new char[n][m];
		
		for(int i = 0; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				miro[i][j] = str.charAt(j);
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		miro[0][0] = '0';
		
		int[] dy = new int[] {0, 0, -1, 1};
		int[] dx = new int[] {1, -1, 0, 0};
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int cy = cur[0] + dy[i];
				int cx = cur[1] + dx[i];
				if(cy < 0 || cx < 0 || cy >= n || cx >= m) continue;
				if(miro[cy][cx] == '0') continue;
				if(cy == n-1 && cx == m-1) {
					ans = cur[2] + 1;
					q.clear();
					break;
				}
				q.offer(new int[] {cy, cx, cur[2]+1});
				miro[cy][cx] = '0';
			}
		}
		
		System.out.println(ans + 1);

	}

}