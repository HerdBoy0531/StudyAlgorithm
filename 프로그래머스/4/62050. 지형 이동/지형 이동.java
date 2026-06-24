import java.util.*;

class Solution {

    int[] parent;
    int N;
    int[][] group;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land, int height) {

        N = land.length;
        group = new int[N][N];

        int groupCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j] == 0) {
                    groupCnt++;
                    bfs(i, j, groupCnt, land, height);
                }
            }
        }

        List<Edge> edges = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    int g1 = group[x][y];
                    int g2 = group[nx][ny];

                    if (g1 == g2) continue;

                    int cost = Math.abs(land[x][y] - land[nx][ny]);

                    edges.add(new Edge(g1, g2, cost));
                }
            }
        }

        Collections.sort(edges, (a, b) -> a.cost - b.cost);

        parent = new int[groupCnt + 1];

        for (int i = 1; i <= groupCnt; i++) {
            parent[i] = i;
        }

        int answer = 0;

        for (Edge edge : edges) {

            if (union(edge.from, edge.to)) {
                answer += edge.cost;
            }
        }

        return answer;
    }

    private void bfs(int sx, int sy, int groupNum,
                     int[][] land, int height) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy});
        group[sx][sy] = groupNum;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (group[nx][ny] != 0) continue;

                int diff = Math.abs(land[x][y] - land[nx][ny]);

                if (diff <= height) {
                    group[nx][ny] = groupNum;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;
        return true;
    }

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}