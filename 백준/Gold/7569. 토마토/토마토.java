import java.io.*;
import java.util.*;

public class Main {

    static int m, n, h;
    static int[][][] tomato;
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[n][m][h];

        Queue<int[]> q = new ArrayDeque<>();

        for(int z = 0; z < h; z++) {
            for(int y = 0; y < n; y++) {

                st = new StringTokenizer(br.readLine());

                for(int x = 0; x < m; x++) {

                    tomato[y][x][z] = Integer.parseInt(st.nextToken());

                    if(tomato[y][x][z] == 1) {
                        q.offer(new int[]{y, x, z});
                    }
                }
            }
        }

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            int y = cur[0];
            int x = cur[1];
            int z = cur[2];

            for(int i = 0; i < 6; i++) {

                int ny = y + dy[i];
                int nx = x + dx[i];
                int nz = z + dz[i];

                if(ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= h) continue;

                if(tomato[ny][nx][nz] == 0) {

                    tomato[ny][nx][nz] = tomato[y][x][z] + 1;

                    q.offer(new int[]{ny, nx, nz});
                }
            }
        }

        int ans = 0;

        for(int z = 0; z < h; z++) {
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < m; x++) {

                    if(tomato[y][x][z] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, tomato[y][x][z]);
                }
            }
        }

        System.out.println(ans - 1);
    }
}