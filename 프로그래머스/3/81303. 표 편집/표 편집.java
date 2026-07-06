import java.util.*;

class Solution {
    
    static class Node {
        int cur;
        int prev;
        int next;
        
        Node(int cur, int prev, int next) {
            this.cur = cur;
            this.prev = prev;
            this.next = next;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        Stack<Node> stack = new Stack<>();
        
        int cur = k;
        
        for(String command : cmd) {
            char operation = command.charAt(0);
            
            if(operation == 'U') {
                int move = Integer.parseInt(command.substring(2));
                
                while(move-- > 0) {
                    cur = prev[cur];
                }
            } else if(operation == 'D') {
                int move = Integer.parseInt(command.substring(2));
                
                while(move-- > 0) {
                    cur = next[cur];
                }
            } else if(operation == 'C') {
                stack.push(new Node(cur, prev[cur], next[cur]));
                
                if(prev[cur] != -1) {
                    next[prev[cur]] = next[cur];
                }
                
                if(next[cur] != -1) {
                    prev[next[cur]] = prev[cur];
                    cur = next[cur];
                } else {
                    cur = prev[cur];
                }
            } else {
                Node restore = stack.pop();
                
                int c = restore.cur;
                int p = restore.prev;
                int nIdx = restore.next;
                
                if(p != -1) {
                    next[p] = c;
                }
                
                if(nIdx != -1) {
                    prev[nIdx] = c;
                }
                
                prev[c] = p;
                next[c] = nIdx;
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        while(!stack.isEmpty()) {
            answer[stack.pop().cur] = 'X';
        }
        
        return new String(answer);
    }
}