import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] Bae;
	static int[][] Warm;
	public static void BFS(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(Warm[ny][nx] == 1) {
					Warm[ny][nx] = 0;
					q.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Warm = new int[N][M];
			int K = Integer.parseInt(st.nextToken());
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				Warm[y][x] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(Warm[i][j] == 1) {
						Warm[i][j] = 0;
						BFS(i, j);
						cnt ++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}