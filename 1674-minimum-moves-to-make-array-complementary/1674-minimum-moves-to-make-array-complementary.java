import java.util.*;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            diff[low] -= 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;

            diff[high + 1] += 1;
        }

        int answer = Integer.MAX_VALUE;

        int current = n;

        for (int target = 2; target <= 2 * limit; target++) {
            current += diff[target];
            answer = Math.min(answer, current);
        }

        return answer;
    }
}