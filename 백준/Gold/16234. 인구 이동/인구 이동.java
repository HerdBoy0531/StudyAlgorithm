import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int day = 0;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int sum = bfs(i, j, union);

                        if (union.size() > 1) {
                            int avg = sum / union.size();
                            for (int[] p : union) {
                                map[p[0]][p[1]] = avg;
                            }
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            day++;
        }

        System.out.println(day);
    }

    static int bfs(int sy, int sx, List<int[]> union) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        visited[sy][sx] = true;

        union.add(new int[]{sy, sx});
        int sum = map[sy][sx];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visited[ny][nx]) continue;

                int diff = Math.abs(map[y][x] - map[ny][nx]);
                if (diff >= L && diff <= R) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                    union.add(new int[]{ny, nx});
                    sum += map[ny][nx];
                }
            }
        }

        return sum;
    }
}