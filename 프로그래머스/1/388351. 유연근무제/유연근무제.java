class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            int last = 0;
            last = schedules[i] + 10;
            
            if(last % 100 >= 60){
                last = last + 40;
            }
            
            boolean come = true;
            
            for(int j = 0; j < 7; j++){
                if(7 - startday == j || 6 - startday == j) continue;
                if(startday == 7 && j == 6) continue;
                if(timelogs[i][j] > last){
                    come = false;
                    break;
                }
            }
            
            if(come){
                answer += 1;
            }
        }
        
        
        return answer;
    }
}