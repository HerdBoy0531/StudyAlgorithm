import java.util.*;

class Solution {
    static HashSet<Integer> hs = new HashSet<>();
    static int[] num;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String numbers) {
        int answer = 0;
        num = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i = 0; i < num.length; i++) {
            num[i] = (int)(numbers.charAt(i) - '0');
        }
        
        dfs(0);
        
        for(int number : hs) {
            if(isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int lev) {

        if(sb.length() > 0) {
            hs.add(Integer.parseInt(sb.toString()));
        }

        if(lev == num.length) return;

        for(int i = 0; i < num.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            sb.append(num[i]);

            dfs(lev + 1);

            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
    
    
    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}