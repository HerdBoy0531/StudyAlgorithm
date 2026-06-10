// GPT 코드입니다
// 문제를 풀기 전 907, 2104, 2386번을 먼저 풀어보는 것이 좋습니다.
import java.util.*;

class Solution {
    static class Pair {
        long val;
        long count;

        Pair(long val, long count) {
            this.val = val;
            this.count = count;
        }
    }

    static class Info {
        long count;
        long sum;

        Info(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    int[] nums;
    int n;
    long totalCount;

    public long maxTotalValue(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        this.totalCount = 1L * n * (n + 1) / 2;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long maxDiff = max - min;
        long left = 0;
        long right = maxDiff;

        while (left < right) {
            long mid = (left + right + 1) / 2;

            Info ge = getGreaterEqual(mid);

            if (ge.count >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        long threshold = left;

        Info greater = getGreaterEqual(threshold + 1);

        long remain = k - greater.count;

        return greater.sum + remain * threshold;
    }

    private Info getGreaterEqual(long limit) {
        Info less = getLessThan(limit);

        long count = totalCount - less.count;
        long totalSum = getTotalRangeSum();
        long sum = totalSum - less.sum;

        return new Info(count, sum);
    }

    private Info getLessThan(long limit) {
        if (limit <= 0) {
            return new Info(0, 0);
        }

        Deque<Pair> maxDeque = new ArrayDeque<>();
        Deque<Pair> minDeque = new ArrayDeque<>();

        long maxSum = 0;
        long minSum = 0;

        long count = 0;
        long sum = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {
            long x = nums[right];

            long cnt = 1;
            while (!maxDeque.isEmpty() && maxDeque.peekLast().val <= x) {
                Pair p = maxDeque.pollLast();
                cnt += p.count;
                maxSum -= p.val * p.count;
            }
            maxDeque.offerLast(new Pair(x, cnt));
            maxSum += x * cnt;

            cnt = 1;
            while (!minDeque.isEmpty() && minDeque.peekLast().val >= x) {
                Pair p = minDeque.pollLast();
                cnt += p.count;
                minSum -= p.val * p.count;
            }
            minDeque.offerLast(new Pair(x, cnt));
            minSum += x * cnt;

            while (!maxDeque.isEmpty()
                    && !minDeque.isEmpty()
                    && maxDeque.peekFirst().val - minDeque.peekFirst().val >= limit) {

                Pair maxFront = maxDeque.peekFirst();
                maxSum -= maxFront.val;
                maxFront.count--;
                if (maxFront.count == 0) {
                    maxDeque.pollFirst();
                }

                Pair minFront = minDeque.peekFirst();
                minSum -= minFront.val;
                minFront.count--;
                if (minFront.count == 0) {
                    minDeque.pollFirst();
                }

                left++;
            }

            long len = right - left + 1;

            count += len;
            sum += maxSum - minSum;
        }

        return new Info(count, sum);
    }

    private long getTotalRangeSum() {
        long maxTotal = getContribution(true);
        long minTotal = getContribution(false);

        return maxTotal - minTotal;
    }

    private long getContribution(boolean isMax) {
        long result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                    (i == n ||
                            (isMax
                                    ? nums[stack.peek()] < nums[i]
                                    : nums[stack.peek()] > nums[i]))) {

                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = 1L * (mid - left) * (right - mid);
                result += count * nums[mid];
            }

            stack.push(i);
        }

        return result;
    }
}