import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int[][] land = new int[landStartTime.length][3];
        int[][] water = new int[waterStartTime.length][3];

        for(int i = 0; i < landStartTime.length; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landStartTime[i] + landDuration[i];
            land[i][2] = i;
        }

        for(int i = 0; i < waterStartTime.length; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterStartTime[i] + waterDuration[i];
            water[i][2] = i;
        }

        Arrays.sort(land, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(water, (a, b) -> Integer.compare(a[1], b[1]));

        int start = land[0][1];
        int end = Integer.MAX_VALUE;
        
        for(int i = 0; i < water.length; i++) {
            if(water[i][0] <= start) {
                end = Math.min(end, start + waterDuration[water[i][2]]);
            } else {
                end = Math.min(end, water[i][1]);
            }
        }

        start = water[0][1];
        for(int i = 0; i < land.length; i++) {
            if(land[i][0] <= start) {
                end = Math.min(end, start + landDuration[land[i][2]]);
            } else {
                end = Math.min(end, land[i][1]);
            }
        }
        
        return end;
    }
}