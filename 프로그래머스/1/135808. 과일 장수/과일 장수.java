import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int Index = m;
        int answer = 0;
        
        // Arrays.sort(arr,Collections.reverseOrder());
        Arrays.sort(score);
        
        for(int i = 1; i <= score.length / m; i++){
            if(score.length - (m * i) < 0) break;
            answer += score[score.length - (m * i)] * m;
        }
        
        // while(score.length - (Index) >= m){
        //     answer += score[Index - 1] * m;
        //     Index += m;
        // }
        
        return answer;
    }
}