import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int maxNum = nums[n-1];
        if(maxNum + 1 != n){
            System.out.println(1);
            return false;
        }

        int checkNum = 1;
        for(int i = 0; i < n; i++) {
            if(i >= n-2) {
                checkNum = maxNum;
            }
            if(nums[i] != checkNum) {
                System.out.println(1);
                return false;
            }

            checkNum += 1;
        }

        return true;
    }
}