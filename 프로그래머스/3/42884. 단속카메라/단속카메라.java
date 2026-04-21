import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int cnt = 1;
        int start, end;
        
        start = routes[0][0];
        end = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= end) {
                if(start <= routes[i][0]){
                    start = routes[i][0];
                }
                if(end >= routes[i][1]){
                    end = routes[i][1];
                }
            } else {
                start = routes[i][0];
                end = routes[i][1];
                cnt += 1;
            }
        }
        
        answer = cnt;
        return answer;
    }
}