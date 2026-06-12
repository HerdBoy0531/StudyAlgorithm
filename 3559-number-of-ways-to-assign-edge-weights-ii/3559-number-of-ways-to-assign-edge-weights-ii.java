import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    List<Integer>[] graph;
    int[][] parent;
    int[] depth;
    int LOG;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        depth = new int[n + 1];
        parent = new int[LOG][n + 1];

        dfs(1, 0);

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }

        int m = queries.length;
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int dist =
                    depth[u]
                    + depth[v]
                    - 2 * depth[lca];

            if (dist == 0) {
                answer[i] = 0;
            } else {
                answer[i] = (int) modPow(2, dist - 1);
            }
        }

        return answer;
    }

    void dfs(int cur, int par) {

        parent[0][cur] = par;

        for (int next : graph[cur]) {
            if (next == par) continue;

            depth[next] = depth[cur] + 1;
            dfs(next, cur);
        }
    }

    int lca(int a, int b) {

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                a = parent[k][a];
            }
        }

        if (a == b) return a;

        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return parent[0][a];
    }

    long modPow(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}