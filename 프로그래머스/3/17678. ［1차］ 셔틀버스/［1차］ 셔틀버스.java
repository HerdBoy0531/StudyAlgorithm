import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        int crewCnt = timetable.length;

        int[] crew = new int[crewCnt];

        for (int i = 0; i < crewCnt; i++) {
            String[] arr = timetable[i].split(":");

            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);

            crew[i] = hour * 60 + min;
        }

        Arrays.sort(crew);

        int idx = 0;
        int busTime = 9 * 60;

        for (int bus = 0; bus < n; bus++) {

            int boarded = 0;

            while (idx < crewCnt &&
                   crew[idx] <= busTime &&
                   boarded < m) {
                idx++;
                boarded++;
            }

            // 마지막 버스
            if (bus == n - 1) {

                int conTime;

                // 자리가 남음
                if (boarded < m) {
                    conTime = busTime;
                }
                // 만석
                else {
                    conTime = crew[idx - 1] - 1;
                }

                int hour = conTime / 60;
                int min = conTime % 60;

                return String.format("%02d:%02d", hour, min);
            }

            busTime += t;
        }

        return "";
    }
}