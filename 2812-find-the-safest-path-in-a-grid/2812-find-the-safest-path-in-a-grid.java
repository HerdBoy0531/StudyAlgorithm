import java.util.*;

class Solution {
    private int n;
    private int[][] dist;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 1. 모든 칸에서 가장 가까운 도둑까지의 거리 구하기
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    q.offer(new int[]{r, c});
                    dist[r][c] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        // 2. PriorityQueue로 안전도가 높은 경로부터 탐색
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int safe = cur[2];

            if (r == n - 1 && c == n - 1) {
                return safe;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;

                int nextSafe = Math.min(safe, dist[nr][nc]);
                pq.offer(new int[]{nr, nc, nextSafe});
            }
        }

        return 0;
    }
}