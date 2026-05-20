class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] nums = new int[n + 1];
        int[] C = new int[n];

        for(int i = 0; i < n; i++) {
            nums[A[i]] += 1;
            nums[B[i]] += 1;

            for(int j = 1; j <= n; j++) {
                if(nums[j] == 2) {
                    C[i] += 1;
                }
            }
        }

        return C;
    }
}