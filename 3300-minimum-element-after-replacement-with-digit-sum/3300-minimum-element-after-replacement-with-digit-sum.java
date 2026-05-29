import java.util.*;

class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            min = Math.min(min, sum);
        }

        return min;
    }
}