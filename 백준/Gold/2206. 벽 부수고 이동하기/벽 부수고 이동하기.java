import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        map = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String road = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = road.charAt(j);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 1}); // y, x, wallBroken, dist
        visited[0][0][0] = true;

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int w = cur[2];
            int dist = cur[3];

            if (y == n - 1 && x == m - 1) {
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                // 빈 칸
                if (map[ny][nx] == '0' && !visited[ny][nx][w]) {
                    visited[ny][nx][w] = true;
                    q.offer(new int[]{ny, nx, w, dist + 1});
                }

                // 벽
                if (map[ny][nx] == '1' && w == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.offer(new int[]{ny, nx, 1, dist + 1});
                }
            }
        }

        System.out.println(-1);
    }
}