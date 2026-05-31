import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;

        long weight = mass;
        boolean poss = true;
        Arrays.sort(asteroids);

        for(int i = 0; i < n; i++) {
            if(weight >= asteroids[i]) {
                weight += asteroids[i];
            } else {
                poss = false;
                break;
            }
        }

        return poss;
    }
}