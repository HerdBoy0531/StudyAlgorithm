import java.util.*;

class Solution {
    
    int[] num;
    int[][] links;
    int k;
    
    public int solution(int k, int[] num, int[][] links) {
        this.num = num;
        this.links = links;
        this.k = k;
        
        int n = num.length;
        
        boolean[] isChild = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(links[i][j] != -1){
                    isChild[links[i][j]] = true;
                }
            }
        }
        
        int root = 0;
        for(int i = 0; i < n; i++){
            if(!isChild[i]){
                root = i;
                break;
            }
        }
        
        int left = 0;
        int right = 0;
        
        for(int x : num){
            left = Math.max(left, x);
            right += x;              
        }
        
        int answer = right;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(check(root, mid) <= k){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    int check(int root, int limit){
        return dfs(root, limit)[1] + 1;
    }
    
    int[] dfs(int cur, int limit){
        int curVal = num[cur];
        
        if(curVal > limit){
            return new int[]{0, Integer.MAX_VALUE};
        }
        
        int left = links[cur][0];
        int right = links[cur][1];
        
        int lSum = 0, rSum = 0;
        int lGroup = 0, rGroup = 0;
        
        if(left != -1){
            int[] l = dfs(left, limit);
            lSum = l[0];
            lGroup = l[1];
        }
        
        if(right != -1){
            int[] r = dfs(right, limit);
            rSum = r[0];
            rGroup = r[1];
        }
        
        int group = lGroup + rGroup;
        
        if(curVal + lSum + rSum <= limit){
            return new int[]{curVal + lSum + rSum, group};
        }
        
        if(curVal + Math.min(lSum, rSum) <= limit){
            group += 1;
            return new int[]{curVal + Math.min(lSum, rSum), group};
        }
        
        group += 2;
        return new int[]{curVal, group};
    }
}