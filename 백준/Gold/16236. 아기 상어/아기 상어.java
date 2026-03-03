import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] shark = new int[2];

    static int sharkSize = 2;
    static int eatCount = 0;
    static int totalTime = 0;

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    static class Fish {
        int y, x, dist;

        Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static List<Fish> bfs() {

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        List<Fish> candidates = new ArrayList<>();

        q.offer(new int[] { shark[0], shark[1], 0 });
        visited[shark[0]][shark[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > sharkSize) continue;

                visited[ny][nx] = true;

                if (map[ny][nx] != 0 && map[ny][nx] < sharkSize) {
                    candidates.add(new Fish(ny, nx, dist + 1));
                }

                q.offer(new int[] { ny, nx, dist + 1 });
            }
        }

        return candidates;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {

            List<Fish> candidates = bfs();

            if (candidates.isEmpty()) break;

            candidates.sort((a, b) -> {
                if (a.dist == b.dist) {
                    if (a.y == b.y)
                        return a.x - b.x;
                    return a.y - b.y;
                }
                return a.dist - b.dist;
            });

            Fish target = candidates.get(0);

            shark[0] = target.y;
            shark[1] = target.x;

            totalTime += target.dist;
            map[target.y][target.x] = 0;

            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);
    }
}