import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        char[] arr = new char[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.charAt(i);
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> alpha = new HashMap<>();
            for(int j = i; j < n; j++){
                alpha.put(arr[j], alpha.getOrDefault(arr[j], 0) + 1);

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int keyCnt = alpha.size();
                for(int v : alpha.values()){
                    max = Math.max(v, max);
                    min = Math.min(v, min);
                }

                if(max == min){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }

        return answer;
    }
}