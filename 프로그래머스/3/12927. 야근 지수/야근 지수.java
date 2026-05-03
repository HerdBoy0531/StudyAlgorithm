import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        while(n > 0) {
            Arrays.sort(works);
            int max = works[works.length-1];
            if(max == 0) break;
            
            for(int i = works.length - 1; i > -1; i--){
                if(n == 0) break;
                if(works[i] == max){
                    works[i] -= 1;
                    n -= 1;
                } else {
                    continue;
                }
            }
        }
        
        for(int i = 0 ; i < works.length; i++) {
            answer += works[i] * works[i];
        }
        
        return answer;
    }
}