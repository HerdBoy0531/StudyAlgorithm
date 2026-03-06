import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};

    static void bfs(int y, int x) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0;i<4;i++) {

                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny<0 || nx<0 || ny>=n || nx>=m) continue;

                if(map[ny][nx] > 0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while(true) {

            visited = new boolean[n][m];
            int cnt = 0;


            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {

                    if(map[i][j] > 0 && !visited[i][j]) {
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            if(cnt >= 2) {
                System.out.println(year);
                return;
            }

            if(cnt == 0) {
                System.out.println(0);
                return;
            }

            int[][] melt = new int[n][m];

            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {

                    if(map[i][j] > 0) {

                        int sea = 0;

                        for(int d=0; d<4; d++) {

                            int ny = i + dy[d];
                            int nx = j + dx[d];

                            if(ny<0 || nx<0 || ny>=n || nx>=m) continue;

                            if(map[ny][nx] == 0) sea++;
                        }

                        melt[i][j] = sea;
                    }
                }
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
                }
            }

            year++;
        }
    }
}