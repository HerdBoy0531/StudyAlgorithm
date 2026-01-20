import java.io.*;

public class Main {
    static int n;
    static int[] lst, arr;
    static boolean[] visited;

    public static void dfs(int tar, int cur) {
        lst[cur]++;

        if (lst[cur] > 1 && cur == tar) {
            visited[cur] = true;
            return;
        }

        if (lst[cur] > 1) return;

        dfs(tar, arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            lst = new int[n + 1];
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                res++;
                sb.append(i).append("\n");
            }
        }

        System.out.println(res);
        System.out.print(sb);
    }
}