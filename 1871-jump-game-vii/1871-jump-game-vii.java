import java.util.*;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int farthest = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int start = Math.max(cur + minJump, farthest);
            int end = Math.min(cur + maxJump, n - 1);

            for (int next = start; next <= end; next++) {
                if (s.charAt(next) == '0' && !visited[next]) {
                    if (next == n - 1) {
                        return true;
                    }

                    visited[next] = true;
                    q.offer(next);
                }
            }

            farthest = Math.max(farthest, end + 1);
        }

        return n == 1;
    }
}