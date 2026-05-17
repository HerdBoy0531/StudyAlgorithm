import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;

        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            int up = cur + arr[cur];
            int down = cur - arr[cur];
            if(arr[cur] == 0) {
                return true;
            }

            if(up < n && !visited[up]) {
                visited[up] = true;
                q.offer(up);
            }
            if(down >= 0 && !visited[down]) {
                visited[down] = true;
                q.offer(down);
            }
        }

        return false;

    }
}