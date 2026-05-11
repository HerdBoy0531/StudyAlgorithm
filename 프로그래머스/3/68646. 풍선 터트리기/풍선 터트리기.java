import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int n = a.length;
        boolean[] check = new boolean[n];
        check[0] = true;
        check[n-1] = true;
        
        int min = a[0];
        for(int i = 1; i < n - 1 ; i++){
            if(min > a[i]) {
                check[i] = true;
            }
            min = Math.min(min, a[i]);
        }
        
        min = a[n-1];
        for(int i = n-1; i > -1; i--){
            if(min > a[i]) {
                check[i] = true;
            }
            min = Math.min(min, a[i]);
        }
        
        for(int i = 0; i < n; i++){
            if(check[i]) {
                answer += 1;
            }
        }
        
        return answer;
    }
}