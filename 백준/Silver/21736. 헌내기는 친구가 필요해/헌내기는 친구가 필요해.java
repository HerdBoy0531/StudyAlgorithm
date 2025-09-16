import java.io.*;
import java.util.*;

public class Main {
	static int[][] visited;
	static char[][] root;
	static int N, M;
	static int res = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		root = new char[N][M];
		visited = new int[N][M];
		
		int start_y = 0, start_x = 0;
		
		for(int i = 0 ; i < N; i++) {
			String Yu = br.readLine();
			for(int j = 0; j < M; j++) {
				root[i][j] = Yu.charAt(j);
				if(root[i][j] == 'I') {
					start_y = i;
					start_x = j;
					visited[i][j] = 1;
				}
			}
		}
		
		
		BFS(start_y, start_x);
		if(res == 0) {
			System.out.println("TT");
			
		}
		else {
			System.out.println(res);
		}
		br.close();
	}
	
	private static void BFS(int y, int x) {
		int[] direct_y = {0, 0, 1, -1};
		int[] direct_x = {1, -1, 0, 0};
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			for(int i = 0; i < 4; i++) {
				int dy = direct_y[i] + cy;
				int dx = direct_x[i] + cx;
				if(dy < 0 || dx < 0 || dy >=N || dx >= M) continue;
				if(root[dy][dx] == 'X' || visited[dy][dx] == 1) continue;
				if(root[dy][dx] == 'P') {
					res += 1;
				}
				q.add(new int[] {dy, dx});
				visited[dy][dx] = 1;
			}
		}
	}

}
