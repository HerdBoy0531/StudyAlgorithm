import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T;
    static int[][] room, temp;
    static int up = -1, down = -1;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && up == -1) {
                    up = i;
                    down = i + 1;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            clean();
        }

        System.out.println(calcDust());
    }

    static void spread() {
        for (int i = 0; i < R; i++) {
            temp[i] = room[i].clone();
        }

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (temp[y][x] > 0) {
                    int spread = temp[y][x] / 5;
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];

                        if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                        if (temp[ny][nx] == -1) continue;

                        room[ny][nx] += spread;
                        cnt++;
                    }
                    room[y][x] -= spread * cnt;
                }
            }
        }
    }

    static void clean() {

        for (int i = up - 1; i > 0; i--) room[i][0] = room[i - 1][0];
        for (int i = 0; i < C - 1; i++) room[0][i] = room[0][i + 1];
        for (int i = 0; i < up; i++) room[i][C - 1] = room[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) room[up][i] = room[up][i - 1];
        room[up][1] = 0;

        for (int i = down + 1; i < R - 1; i++) room[i][0] = room[i + 1][0];
        for (int i = 0; i < C - 1; i++) room[R - 1][i] = room[R - 1][i + 1];
        for (int i = R - 1; i > down; i--) room[i][C - 1] = room[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) room[down][i] = room[down][i - 1];
        room[down][1] = 0;

        room[up][0] = room[down][0] = -1;
    }

    static int calcDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) sum += room[i][j];
            }
        }
        return sum;
    }
}
