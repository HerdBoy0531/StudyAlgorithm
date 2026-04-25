import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

 
        for (String name : callings) {
            int idx = map.get(name);

            String frontPlayer = players[idx - 1];

            players[idx - 1] = name;
            players[idx] = frontPlayer;

            map.put(name, idx - 1);
            map.put(frontPlayer, idx);
        }

        return players;
    }
}