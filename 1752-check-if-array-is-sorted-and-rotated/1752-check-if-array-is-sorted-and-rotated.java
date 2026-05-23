class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        for(int i = 0; i < n-1; i++) {
            int num = nums[i];
            if(num > nums[i + 1]) {
                cnt += 1;
                num = nums[i + 1];
                
                if(cnt == 2) {
                    return false;
                }
            }

            num = nums[i + 1];
        }

        if(nums[0] < nums[n-1] && cnt == 1) {
            return false;
        }
        return true;
        
    }
}