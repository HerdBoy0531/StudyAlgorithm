import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] pick;
    static boolean[] visited, finished;
    static int cycleCnt;

    static void dfs(int cur) {
        visited[cur] = true;
        int next = pick[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            cycleCnt++;
            for (int v = next; v != cur; v = pick[v]) {
                cycleCnt++;
            }
        }

        finished[cur] = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            pick = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cycleCnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) pick[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(n - cycleCnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}