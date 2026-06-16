import java.util.*;

class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        boolean reverse = false;

        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 마지막 것 삭제
            if(ch == '*'){
                if(reverse) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }
            
            // 마지막 문자 다시 추가
            else if(ch == '#') {
                if(dq.peek() == null) continue;
                while(!dq.isEmpty()){
                    sb.append(dq.poll());
                }
                for(int j = 0; j < 2; j++) {
                    for(int k = 0; k < sb.length(); k++) {
                        dq.offer(sb.charAt(k));
                    }
                }

                sb.setLength(0);
            }
            
            // 문자열 뒤집기
            else if(ch == '%'){
                if(reverse) {
                    reverse = false;
                } else {
                    reverse = true;
                }
            }
            
            // 문자 추가
            else {
                if(reverse) {
                    dq.offerFirst(ch);
                } else {
                    dq.offerLast(ch);
                }
            }

        }

        while(!dq.isEmpty()) {
            if(reverse) {
                sb.append(dq.pollLast());
            } else {
                sb.append(dq.pollFirst());
            }
        }

        return sb.toString();
    }
}