class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        
        int answer = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(canJump(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean canJump(int[] stones, int k, int mid) {
        int jumpCnt = 0;
        
        for(int stone : stones) {
            if(stone < mid) {
                jumpCnt++;
            } else {
                jumpCnt = 0;
            }
            
            if(jumpCnt >= k){
                return false;
            }
        }
        
        return true;
    }
}