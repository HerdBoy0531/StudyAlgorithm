import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] island;
	static boolean[][] visited;
	static int[] directY = new int[] {0, 0, 1, -1};
	static int[] directX = new int[] {1, -1, 0, 0};
	static int res = Integer.MAX_VALUE;
	
    static void labelIsland(int y, int x, int label) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        island[y][x] = label;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int dy = cy + directY[d];
                int dx = cx + directX[d];

                if (dy < 0 || dx < 0 || dy >= n || dx >= n) continue;
                if (visited[dy][dx] || island[dy][dx] == 0) continue;

                visited[dy][dx] = true;
                island[dy][dx] = label;
                q.offer(new int[]{dy, dx});
            }
        }
    }
    static void buildBridge(int islandNum) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == islandNum) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int d = 0; d < 4; d++) {
                int dy = y + directY[d];
                int dx = x + directX[d];

                if (dy < 0 || dx < 0 || dy >= n || dx >= n) continue;

                if (island[dy][dx] != 0 && island[dy][dx] != islandNum) {
                    res = Math.min(res, dist[y][x]);
                    return;
                }

                if (island[dy][dx] == 0 && dist[dy][dx] == -1) {
                    dist[dy][dx] = dist[y][x] + 1;
                    q.offer(new int[]{dy, dx});
                }
            }
        }
    }

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        island = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int label = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, label++);
                }
            }
        }

        for (int i = 2; i < label; i++) {
            buildBridge(i);
        }

        System.out.println(res);
	}

}