class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        String str ="";

        for(int i = 0; i < n; i++){
            String num = Integer.toString(nums[i]);
            str += num;
        }

        int[] answer = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            answer[i] = str.charAt(i) - '0';
        }
        return answer;
    }
}