import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;

        for (int m = 0; m < n - 1; m++) {
            int left = m;
            int right = m + 1;

            int leftCookie = cookie[left];
            int rightCookie = cookie[right];

            while (true) {
                if (leftCookie == rightCookie) {
                    answer = Math.max(answer, leftCookie);
                }

                if (leftCookie <= rightCookie) {
                    left--;

                    if (left < 0) {
                        break;
                    }

                    leftCookie += cookie[left];
                } else {
                    right++;

                    if (right >= n) {
                        break;
                    }

                    rightCookie += cookie[right];
                }
            }
        }

        return answer;
    }
}