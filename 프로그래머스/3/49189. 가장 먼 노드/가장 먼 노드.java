import java.util.*;

class Solution {
    static int N, answer, maxLine;
    static boolean[][] arr;
    static boolean[] visited;
    
    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int line = cur[1];
            boolean go = false;
            
            for(int i = 0; i < N; i++) {
                if(!visited[i] && arr[now][i]) {
                    q.offer(new int[] {i, line + 1});
                    go = true;
                    visited[i] = true;
                }
            }
            
            if(!go) {
                if(maxLine < line) {
                    maxLine = line;
                    answer = 1;
                } 
                else if(maxLine == line){
                    answer += 1;
                }
            }
        }
    }
    
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        maxLine = 0;
        N = n;
        arr = new boolean[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < edge.length; i++){
            for(int j = 0; j < 2; j++){
                int a = edge[i][0] - 1;
                int b = edge[i][1] - 1;
                
                arr[a][b] = true;
                arr[b][a] = true;
            }
        }
        
        bfs();
        
        return answer;
    }
}