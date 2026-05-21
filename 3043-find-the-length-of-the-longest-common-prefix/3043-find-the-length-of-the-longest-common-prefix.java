import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < n1; i++) {
            String s = Integer.toString(arr1[i]);
            for(int j = 1; j <= s.length(); j++) {
                hs.add(s.substring(0, j));
            }
        }

        int ans = 0;
        for(int i = 0; i < n2; i++) {
            String s = Integer.toString(arr2[i]);

            for(int j = 1; j <= s.length(); j++) {
                if(hs.contains(s.substring(0,j))) {
                    ans = Math.max(ans, j);
                }
            }

        }

        return ans;
    }
}