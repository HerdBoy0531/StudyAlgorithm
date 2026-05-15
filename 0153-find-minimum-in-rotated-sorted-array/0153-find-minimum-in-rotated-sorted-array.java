import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }

        int ans = pq.poll();

        return ans;
    }
}