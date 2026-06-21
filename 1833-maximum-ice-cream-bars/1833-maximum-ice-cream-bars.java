class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] count = new int[maxCost + 1];

        for (int cost : costs) {
            count[cost]++;
        }

        int answer = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (count[cost] == 0) continue;

            int canBuy = Math.min(count[cost], coins / cost);

            answer += canBuy;
            coins -= canBuy * cost;

            if (coins < cost) {
                // 더 비싼 아이스크림은 못 사므로 종료 가능
                continue;
            }
        }

        return answer;
    }
}