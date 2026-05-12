import java.util.*;

class Solution {

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    static List<Integer> getPrimeFactors(int num) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                factors.add(i);

                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 1) {
            factors.add(num);
        }

        return factors;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer>[] factors = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            factors[i] = new ArrayList<>();

            List<Integer> primes = getPrimeFactors(nums[i]);

            for (int p : primes) {

                factors[i].add(p);

                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[n];

        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);

        visited[0] = true;

        int jump = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int cur = q.poll();

                if (cur == n - 1) {
                    return jump;
                }

                int left = cur - 1;

                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    q.offer(left);
                }

                int right = cur + 1;

                if (right < n && !visited[right]) {
                    visited[right] = true;
                    q.offer(right);
                }

                int value = nums[cur];

                if (isPrime(value) && !usedPrime.contains(value)) {

                    for (int next : map.get(value)) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    usedPrime.add(value);
                }
            }

            jump++;
        }

        return -1;
    }
}