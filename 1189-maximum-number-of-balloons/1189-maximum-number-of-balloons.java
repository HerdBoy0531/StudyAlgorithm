class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] check = new int[5];

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'b') {
                check[0]++;
            } else if(text.charAt(i) == 'a') {
                check[1]++;
            } else if(text.charAt(i) == 'l') {
                check[2]++;
            } else if(text.charAt(i) == 'o') {
                check[3]++;
            } else if(text.charAt(i) == 'n') {
                check[4]++;
            }
        }

        check[2] /= 2;
        check[3] /= 2;

        int ans = Integer.MAX_VALUE;
        for(int c : check) {
            ans = Math.min(ans, c);
        }

        return ans;
    }
}