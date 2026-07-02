import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int r = grid.size();
        int c = grid.get(0).size();

        int[][] dist = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int startCost = grid.get(0).get(0);

        dist[0][0] = startCost;
        pq.offer(new int[]{0, 0, startCost});

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];

            if (cost > dist[y][x]) continue;

            if (y == r - 1 && x == c - 1) {
                return cost < health;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;

                int nextCost = cost + grid.get(ny).get(nx);

                if (nextCost < dist[ny][nx]) {
                    dist[ny][nx] = nextCost;
                    pq.offer(new int[]{ny, nx, nextCost});
                }
            }
        }

        return false;
    }
}