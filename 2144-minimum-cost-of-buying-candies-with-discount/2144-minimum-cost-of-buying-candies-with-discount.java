import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        int check = 0;
        int ans = 0;

        Arrays.sort(cost);
        for(int i = n-1; i >= 0; i--) {
            if(check == 2){
                check =0;
                continue;
            }
            ans += cost[i];
            check += 1;
        }

        return ans;
    }
}