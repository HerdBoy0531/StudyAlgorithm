import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        Queue<Integer> lowQ = new ArrayDeque<>();
        Queue<Integer> highQ = new ArrayDeque<>();
        int same = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot) {
                lowQ.offer(nums[i]);
            } else if(nums[i] > pivot) {
                highQ.offer(nums[i]);
            } else {
                same++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(!lowQ.isEmpty()) {
                nums[i] = lowQ.poll();
            } else if(same != 0) {
                nums[i] = pivot;
                same--;
            } else {
                nums[i] = highQ.poll();
            }
        }

        return nums;
    }
}