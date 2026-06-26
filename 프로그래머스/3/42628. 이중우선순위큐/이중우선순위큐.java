import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        TreeSet<Integer> ts = new TreeSet<>();

        for(int i = 0; i < operations.length; i++) {

            String[] oper = operations[i].split(" ");

            if(oper[0].equals("I")) {

                int num = Integer.parseInt(oper[1]);
                ts.add(num);

            } else {

                if(ts.isEmpty()) continue;

                if(oper[1].equals("1")) {
                    ts.pollLast();
                } else {
                    ts.pollFirst();
                }
            }
        }

        if(!ts.isEmpty()) {
            return new int[]{ts.last(), ts.first()};
        }

        return new int[]{0, 0};
    }
}