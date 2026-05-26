import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        int[] up = new int[26];
        int[] down = new int[26];

        for(int i = 0; i < n; i++) {
            char one = word.charAt(i);
            if(Character.isUpperCase(one) && up[word.charAt(i) - 'A'] == 0) {
                up[one - 'A'] += 1;
            } else if (!Character.isUpperCase(one) && down[word.charAt(i) - 'a'] == 0) {
                down[one - 'a'] += 1;
            }
        }

        int res = 0;
        for(int i = 0; i < 26; i++) {
            System.out.println(i+" " +up[i] + " " + down[i]);
            if(up[i] > 0 && down[i] > 0) {
                res += 1;
            }
        }

        return res;
    }
}