class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int n1Idx = 0;
        int n2Idx = 0;

        while(true) {
            if(n1Idx == n1 || n2Idx == n2) break;
            if(nums1[n1Idx] == nums2[n2Idx]) {
                return nums1[n1Idx];
            } else if(nums1[n1Idx] > nums2[n2Idx]) {
                n2Idx += 1;
            } else {
                n1Idx += 1;
            }
        }

        return -1;
    }
}