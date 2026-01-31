import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int cleanCnt = 0;

        while (true) {

            if (!visited[r][c]) {
                visited[r][c] = true;
                cleanCnt++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int ny = r + dy[d];
                int nx = c + dx[d];

                if (map[ny][nx] == 0 && !visited[ny][nx]) {
                    r = ny;
                    c = nx;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int backDir = (d + 2) % 4;
                int ny = r + dy[backDir];
                int nx = c + dx[backDir];

                if (map[ny][nx] == 1) {
                    break;
                } else {
                    r = ny;
                    c = nx;
                }
            }
        }

        System.out.println(cleanCnt);
    }
}
