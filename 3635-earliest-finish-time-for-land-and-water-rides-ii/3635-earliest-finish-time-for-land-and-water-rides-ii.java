import java.util.*;

class Solution {
    static class Ride {
        int start;
        int duration;

        Ride(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        Ride[] land = buildRides(landStartTime, landDuration);
        Ride[] water = buildRides(waterStartTime, waterDuration);

        Helper landHelper = new Helper(land);
        Helper waterHelper = new Helper(water);

        long answer = Long.MAX_VALUE;

        // 1. 육상 → 수상
        for (Ride r : land) {
            long finishLand = (long) r.start + r.duration;
            answer = Math.min(answer, waterHelper.getEarliestFinish(finishLand));
        }

        // 2. 수상 → 육상
        for (Ride r : water) {
            long finishWater = (long) r.start + r.duration;
            answer = Math.min(answer, landHelper.getEarliestFinish(finishWater));
        }

        return (int) answer;
    }

    private Ride[] buildRides(int[] startTime, int[] duration) {
        int n = startTime.length;
        Ride[] rides = new Ride[n];

        for (int i = 0; i < n; i++) {
            rides[i] = new Ride(startTime[i], duration[i]);
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a.start, b.start));

        return rides;
    }

    static class Helper {
        Ride[] rides;
        int[] starts;
        long[] prefixMinDuration;
        long[] suffixMinFinish;

        Helper(Ride[] rides) {
            this.rides = rides;
            int n = rides.length;

            starts = new int[n];
            prefixMinDuration = new long[n];
            suffixMinFinish = new long[n];

            for (int i = 0; i < n; i++) {
                starts[i] = rides[i].start;

                if (i == 0) {
                    prefixMinDuration[i] = rides[i].duration;
                } else {
                    prefixMinDuration[i] = Math.min(prefixMinDuration[i - 1], rides[i].duration);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                long finish = (long) rides[i].start + rides[i].duration;

                if (i == n - 1) {
                    suffixMinFinish[i] = finish;
                } else {
                    suffixMinFinish[i] = Math.min(suffixMinFinish[i + 1], finish);
                }
            }
        }

        long getEarliestFinish(long curTime) {
            int idx = upperBound(starts, curTime) - 1;
            long result = Long.MAX_VALUE;

            // 이미 열려 있는 놀이기구 중 duration이 가장 짧은 것 선택
            if (idx >= 0) {
                result = Math.min(result, curTime + prefixMinDuration[idx]);
            }

            // 아직 안 열린 놀이기구 중 start + duration이 가장 빠른 것 선택
            if (idx + 1 < rides.length) {
                result = Math.min(result, suffixMinFinish[idx + 1]);
            }

            return result;
        }

        private int upperBound(int[] arr, long target) {
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int mid = (left + right) / 2;

                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}