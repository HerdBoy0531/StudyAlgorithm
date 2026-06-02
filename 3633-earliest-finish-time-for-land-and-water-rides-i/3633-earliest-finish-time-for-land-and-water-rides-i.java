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

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        Ride[] lands = new Ride[landStartTime.length];
        Ride[] waters = new Ride[waterStartTime.length];

        for (int i = 0; i < landStartTime.length; i++) {
            lands[i] = new Ride(landStartTime[i], landDuration[i]);
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            waters[i] = new Ride(waterStartTime[i], waterDuration[i]);
        }

        ans = Math.min(ans, solve(lands, waters)); // Land -> Water
        ans = Math.min(ans, solve(waters, lands)); // Water -> Land

        return (int) ans;
    }

    private long solve(Ride[] first, Ride[] second) {

        Arrays.sort(second, (a, b) -> Integer.compare(a.start, b.start));

        int m = second.length;

        int[] starts = new int[m];

        long[] prefixMinDuration = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = second[i].start;
        }

        prefixMinDuration[0] = second[0].duration;
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                Math.min(prefixMinDuration[i - 1], second[i].duration);
        }

        suffixMinFinish[m - 1] =
            (long) second[m - 1].start + second[m - 1].duration;

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                suffixMinFinish[i + 1],
                (long) second[i].start + second[i].duration
            );
        }

        long res = Long.MAX_VALUE;

        for (Ride ride : first) {

            long finishTime =
                (long) ride.start + ride.duration;

            int idx = upperBound(starts, finishTime);

            long cur = Long.MAX_VALUE;

            // start <= finishTime 인 놀이기구
            if (idx > 0) {
                cur = Math.min(
                    cur,
                    finishTime + prefixMinDuration[idx - 1]
                );
            }

            // start > finishTime 인 놀이기구
            if (idx < m) {
                cur = Math.min(
                    cur,
                    suffixMinFinish[idx]
                );
            }

            res = Math.min(res, cur);
        }

        return res;
    }

    private int upperBound(int[] arr, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}