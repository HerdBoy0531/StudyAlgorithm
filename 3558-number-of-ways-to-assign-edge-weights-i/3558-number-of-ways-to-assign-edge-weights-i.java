import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    List<Integer>[] graph;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {

        if(edges.length == 0) {
            return 0;
        }

        int maxNode = 0;

        for(int[] edge : edges) {
            maxNode = Math.max(maxNode, edge[0]);
            maxNode = Math.max(maxNode, edge[1]);
        }

        graph = new ArrayList[maxNode + 1];

        for(int i = 1; i <= maxNode; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0, 0);

        return (int)pow(2, maxDepth - 1);
    }

    void dfs(int cur, int parent, int depth) {

        boolean isLeaf = true;

        for(int next : graph[cur]) {
            if(next == parent) continue;

            isLeaf = false;
            dfs(next, cur, depth + 1);
        }

        if(isLeaf) {
            maxDepth = Math.max(maxDepth, depth);
        }
    }

    long pow(long base, long exp) {

        long res = 1;

        while(exp > 0) {

            if((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}