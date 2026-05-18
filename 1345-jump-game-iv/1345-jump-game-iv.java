import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(new int[]{0, 0});
        visited[0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int cnt = cur[1];
            
            if(curX == n-1) {
                return cnt;
            }


            int up = curX + 1;
            int down = curX - 1;
            if(up < n && !visited[up]) {
                q.offer(new int[]{up, cnt+1});
                visited[up] = true;
            } 
            if(down >= 0 && !visited[down]) {
                q.offer(new int[]{down, cnt+1});
                visited[down] = true;
            }
            if(map.containsKey(arr[curX])) {
                for(int next : map.get(arr[curX])) {
                    if(!visited[next]) {
                        visited[next] = true;
                        q.offer(new int[]{next, cnt + 1});
                    }
                }

                map.remove(arr[curX]);
            }
        }

        return 0;
    }
}