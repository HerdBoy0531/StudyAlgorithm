import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph[X][Y] = 1;
            graph[Y][X] = 1;
        }

        // DFS
        dfs(V);
        System.out.println();

        // BFS
        Arrays.fill(visited, false); // 방문 초기화
        bfs(V);
    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
