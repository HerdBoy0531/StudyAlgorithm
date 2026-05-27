import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        boolean[] up = new boolean[26];
        boolean[] down = new boolean[26];
        for(int i = 0; i < n; i++) {
            char w = word.charAt(i);

            if(Character.isUpperCase(w)) {
                up[w - 'A'] = true;
            } else if(Character.isLowerCase(w)) {
                if(up[w - 'a']) {
                    down[w - 'a'] = false;
                } else {
                    down[w - 'a']  = true;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 26; i++) {
            if(up[i] && down[i]) {
                res += 1;
            }
        }

        return res;
    }
}