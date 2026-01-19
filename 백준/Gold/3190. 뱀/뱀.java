import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> command = new HashMap<>();

    // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            board[y][x] = 1; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            command.put(t, d);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0, 0});
        board[0][0] = 2;

        int dir = 0; // 오른쪽
        int time = 0;
        int y = 0, x = 0;

        while (true) {
            time++;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            // 벽 충돌
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
            // 자기 몸 충돌
            if (board[ny][nx] == 2) break;

            // 이동
            snake.offerFirst(new int[]{ny, nx});

            if (board[ny][nx] == 1) {
                // 사과 먹음 → 꼬리 유지
                board[ny][nx] = 2;
            } else {
                // 사과 없음 → 꼬리 제거
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
                board[ny][nx] = 2;
            }

            y = ny;
            x = nx;

            // 방향 전환
            if (command.containsKey(time)) {
                char c = command.get(time);
                if (c == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }

        System.out.println(time);
    }
}