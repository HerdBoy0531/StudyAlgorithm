import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // target 찾음
            if (nums[mid] == target) {
                return mid;
            }

            // 왼쪽 구간이 정렬된 경우
            if (nums[left] <= nums[mid]) {
                // target이 왼쪽 정렬 구간 안에 있는가?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 오른쪽 구간이 정렬된 경우
            else {
                // target이 오른쪽 정렬 구간 안에 있는가?
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}