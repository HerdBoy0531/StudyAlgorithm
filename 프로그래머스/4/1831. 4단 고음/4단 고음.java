class Solution {
    static int answer;

    static void dfs(int n, int plusCnt) {

        if (n == 3 && plusCnt == 2) {
            answer++;
            return;
        }

        if (n < 3) return;

        int starCnt = 0;
        int temp = n;
        while (temp >= 3) {
            temp /= 3;
            starCnt++;
        }

        if (plusCnt > starCnt * 2) return;

        dfs(n - 1, plusCnt + 1);

        if (n % 3 == 0 && plusCnt >= 2) {
            dfs(n / 3, plusCnt - 2);
        }
    }

    public int solution(int n) {
        answer = 0;
        dfs(n, 0);
        return answer;
    }
}