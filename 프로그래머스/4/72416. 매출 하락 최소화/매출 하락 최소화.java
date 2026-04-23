import java.util.*;

class Solution {

    ArrayList<Integer>[] graph;
    int[][] dp;
    int[] sales;

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        this.sales = sales;

        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] link : links){
            int parent = link[0] - 1;
            int child = link[1] - 1;
            graph[parent].add(child);
        }

        dp = new int[n][2];

        dfs(0);

        return Math.min(dp[0][0], dp[0][1]);
    }

    void dfs(int node){

        dp[node][0] = 0;
        dp[node][1] = sales[node];

        if(graph[node].isEmpty()){
            return;
        }

        int sum = 0;
        boolean attended = false;
        int extra = Integer.MAX_VALUE;

        for(int child : graph[node]){
            dfs(child);

            if(dp[child][1] <= dp[child][0]){
                sum += dp[child][1];
                attended = true;
            } else {
                sum += dp[child][0];
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            }
        }

        dp[node][0] = sum;
        if(!attended){
            dp[node][0] += extra;
        }

        dp[node][1] += sum;
    }
}