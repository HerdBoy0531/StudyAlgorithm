import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String[][] castle;
    static int[][] map;
    static int[] roomSize;
    static int roomCnt = 1;
    static int maxRoom = 0;
    static int maxBreak = 0;

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        map[y][x] = roomCnt;

        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                if (castle[cy][cx].charAt(i) == '1') continue;

                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (map[ny][nx] != 0) continue;

                map[ny][nx] = roomCnt;
                q.offer(new int[]{ny, nx});
                size++;
            }
        }

        roomSize[roomCnt] = size;
        maxRoom = Math.max(maxRoom, size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로

        castle = new String[m][n];
        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                String bin = String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0');
                castle[i][j] = new StringBuilder(bin).reverse().toString();
            }
        }

        roomSize = new int[m * n + 1];

        // 1. 방 개수 + 최대 방 크기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                    roomCnt++;
                }
            }
        }

        // 2. 벽 하나 부쉈을 때 최대 방
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;

                    if (map[i][j] != map[ny][nx]) {
                        maxBreak = Math.max(maxBreak,
                                roomSize[map[i][j]] + roomSize[map[ny][nx]]);
                    }
                }
            }
        }

        System.out.println(roomCnt - 1);
        System.out.println(maxRoom);
        System.out.println(maxBreak);
    }
}