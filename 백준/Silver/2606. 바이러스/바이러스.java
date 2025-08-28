import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());   // 컴퓨터 수
        int node = Integer.parseInt(br.readLine());  // 간선 수(연결 수)

        int[][] arr = new int[com][com];   // 인접 행렬 (0-index)
        int[] visited = new int[com];

        for (int i = 0; i < node; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; // 1-index → 0-index
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        int infected = bfs(0, arr, visited); // 0번(=1번 컴퓨터)에서 시작
        System.out.println(infected);        // 시작점 제외 감염 수
        br.close();
    }

    // 시작 정점에서 도달 가능한 다른 정점 수를 반환
    private static int bfs(int start, int[][] arr, int[] visited) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;

        int count = 0; // 시작 정점을 제외한 감염 수

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                if (arr[cur][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    q.offer(i);
                    count++; // 새로 감염된 컴퓨터
                }
            }
        }
        return count;
    }
}