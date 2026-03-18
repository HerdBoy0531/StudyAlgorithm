import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][][] visited = new boolean[n][m][64];
        Queue<int[]> q = new ArrayDeque<>();

        int startY = 0;
        int startX = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    startY = i;
                    startX = j;
                    map[i][j] = '.';
                }
            }
        }

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        q.offer(new int[]{startY, startX, 0, 0});
        visited[startY][startX][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int key = cur[2];
            int dist = cur[3];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nKey = key;

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == '#') continue;

                char next = map[ny][nx];

                if (next == '1') {
                    System.out.println(dist + 1);
                    return;
                }

                if (next >= 'A' && next <= 'F') {
                    if ((key & (1 << (next - 'A'))) == 0) continue;
                }

                if (next >= 'a' && next <= 'f') {
                    nKey = key | (1 << (next - 'a'));
                }

                if (visited[ny][nx][nKey]) continue;

                visited[ny][nx][nKey] = true;
                q.offer(new int[]{ny, nx, nKey, dist + 1});
            }
        }

        System.out.println(-1);
    }
}
