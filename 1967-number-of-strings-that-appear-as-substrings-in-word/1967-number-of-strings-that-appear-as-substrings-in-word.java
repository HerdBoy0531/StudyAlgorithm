import java.util.*;

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        Set<String> hs = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            for(int j = i ; j <= word.length(); j++) {
                String str = word.substring(i, j);
                System.out.println(str);
                hs.add(str);
            }
        }

        int answer = 0;
        for(String pattern : patterns) {
            if(hs.contains(pattern)) answer++;
        }

        return answer;

    }
}