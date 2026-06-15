import java.util.*;

class Solution {
    private int n, ans;
    private boolean[] visited;
    private int[][] dungeon;
    
    
    public int solution(int k, int[][] dungeons) {
        ans = -1;
        n = dungeons.length;
        visited = new boolean[n];
        dungeon = dungeons;
        
        dfs(0, k);
        
        return ans;
    }
    
    private void dfs(int enter, int tiredness) {
        
        ans = Math.max(ans, enter);
        
        for(int i = 0; i < n; i++) {
            if(visited[i] || tiredness < dungeon[i][0]) continue;
            visited[i] = true;
            tiredness -= dungeon[i][1];
            dfs(enter + 1, tiredness);
            visited[i] = false;
            tiredness += dungeon[i][1];
        }
        return;
    }
}