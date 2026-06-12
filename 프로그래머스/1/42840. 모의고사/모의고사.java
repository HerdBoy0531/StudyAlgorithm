import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for(int i = 0; i < answers.length; i++) {
            if(person1[i % 5] == answers[i]) p1++;
            if(person2[i % 8] == answers[i]) p2++;
            if(person3[i % 10] == answers[i]) p3++;
        }

        int max = Math.max(p1, Math.max(p2, p3));

        List<Integer> list = new ArrayList<>();

        if(p1 == max) list.add(1);
        if(p2 == max) list.add(2);
        if(p3 == max) list.add(3);

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}