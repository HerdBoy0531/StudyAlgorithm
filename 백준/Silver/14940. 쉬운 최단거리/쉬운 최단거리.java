
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] dist;
	static int N, M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		int sy = -1, sx = -1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii = 0; ii < M; ii++) {
				arr[i][ii] = Integer.parseInt(st.nextToken());
				if(arr[i][ii] == 2) {
					sy = i;
					sx = ii;
				}
				if (arr[i][ii] == 0) {
					dist[i][ii] = 0;
				}
			}
		}
		
		bfs(sy, sx);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i++) {
			for(int ii = 0; ii < M; ii++) {
				sb.append(dist[i][ii]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
		br.close();
	}
	
	private static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		dist[y][x] = 0;
		
		int[] directY = {-1, 1, 0, 0};
		int[] directX = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			int[] lst = q.poll();
			int cy = lst[0];
			int cx = lst[1];

			for(int i = 0; i < 4; i++) {
				int dy = cy + directY[i];
				int dx = cx + directX[i];
				if(dy < 0 || dy >= N || dx < 0 || dx >= M) continue;
				if(arr[dy][dx] == 0) continue;
				if(dist[dy][dx] != -1) continue;
				dist[dy][dx] = dist[cy][cx] + 1;
				q.offer(new int[] {dy, dx});
			}
		}

	}

}
