import java.io.*;
import java.util.*;

class Solution {
    static int row, col;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};
    
    public int bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        
        int foods = 0;
        
        foods = (int)(map[y][x] - '0');
        visited[y][x] = false;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < 0 || nx < 0 || ny >= row || nx >= col) continue;
                if(!visited[ny][nx]) continue;
                foods += (int)(map[ny][nx] - '0');
                visited[ny][nx] = false;
                q.offer(new int[]{ny, nx});
            }
        }
        
        return foods;
    }
    
    public int[] solution(String[] maps) {
        
        ArrayList<Integer> island = new ArrayList<>();
        
        row = maps.length;
        col = maps[0].length();
        // int[] answer = new int[]{row, col};
        
        map = new char[row][col];
        visited = new boolean[row][col];
        
        boolean check = true;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] >= '1' && map[i][j] <= '9'){
                    check = false;
                    visited[i][j] = true;
                }
            }
        }
        if(check){
            island.add(-1);
            int[] answer = new int[1];
            answer[0] = island.get(0);
            return answer;
        } 
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] >= '1' && map[i][j] <= '9' && visited[i][j]){
                    int res = 0;
                    res = bfs(i, j);
                    island.add(res);
                }
            }
        }
        
        int[] answer = new int[island.size()];
        
        for(int i = 0; i < island.size(); i++){
            answer[i] = island.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}