import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {1, 0}; // 아래, 오른쪽
    static int[] dx = {0, 1};

    public static boolean Bfs(int[][] arr, int sy, int sx, int N){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();

        // 시작이 곧바로 목표인 경우
        if (arr[sy][sx] == -1) return true;

        queue.add(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];
            int jump = arr[y][x];

            // 목적지 찾음
            if (jump == -1) return true;

            // 점프가 0이면 더 진행 불가 (막다른 길)
            if (jump == 0) continue;

            for (int d = 0; d < 2; d++) {
                int ny = y + dy[d] * jump;
                int nx = x + dx[d] * jump;

                // 방향별로 개별 경계 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;

                if (arr[ny][nx] == -1) return true; // 다음 칸이 목표면 즉시 성공
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return false; // 더 갈 곳 없음
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean res = Bfs(arr, 0, 0, N);
        System.out.println(res ? "HaruHaru" : "Hing");
    }
}
