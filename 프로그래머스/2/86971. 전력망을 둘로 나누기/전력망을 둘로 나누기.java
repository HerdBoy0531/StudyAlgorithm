import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        for(int cut = 0; cut < wires.length; cut++) {

            List<Integer>[] graph = new ArrayList[n + 1];

            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < wires.length; i++) {

                if(i == cut) continue;

                int a = wires[i][0];
                int b = wires[i][1];

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean[] visited = new boolean[n + 1];

            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            visited[1] = true;

            int count = 1;

            while(!q.isEmpty()) {

                int cur = q.poll();

                for(int next : graph[cur]) {

                    if(visited[next]) continue;

                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }

            answer = Math.min(
                answer,
                Math.abs(count - (n - count))
            );
        }

        return answer;
    }
}