import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int answer = 1;

        for (long num : count.keySet()) {
            // 1은 따로 처리
            if (num == 1) {
                int c = count.get(num);
                if (c % 2 == 1) {
                    answer = Math.max(answer, c);
                } else {
                    answer = Math.max(answer, c - 1);
                }
                continue;
            }

            long cur = num;
            int length = 0;

            while (count.containsKey(cur)) {
                int c = count.get(cur);

                if (c >= 2) {
                    length += 2;
                    cur = cur * cur;

                    // int 범위를 너무 벗어나면 더 볼 필요 없음
                    if (cur > 1_000_000_000L) {
                        break;
                    }
                } else {
                    length += 1;
                    break;
                }
            }

            // 끝까지 2개씩만 사용했다면 가운데가 없으므로 1개 제거
            if (length % 2 == 0) {
                length--;
            }

            answer = Math.max(answer, length);
        }

        return answer;
    }
}