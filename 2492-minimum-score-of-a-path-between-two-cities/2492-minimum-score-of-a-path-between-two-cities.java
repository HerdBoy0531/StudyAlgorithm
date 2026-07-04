import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int dist = road[2];

            graph[a].add(new int[]{b, dist});
            graph[b].add(new int[]{a, dist});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        visited[1] = true;

        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : graph[cur]) {
                int nextCity = next[0];
                int dist = next[1];

                answer = Math.min(answer, dist);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    q.offer(nextCity);
                }
            }
        }

        return answer;
    }
}