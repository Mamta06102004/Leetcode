class Solution {
    public int maxCoins(int[] nums) {
        // ITERATIVE APPROACH

        int n = nums.length;
        int[] arr = new int[n+2];
        int m = arr.length;
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int i=0; i<n; i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[m][m];

        for(int gap=2; gap<m; gap++){
            for(int s=0; s<=m-1-gap; s++){
                int e = s+gap;
                int ans = Integer.MIN_VALUE;
                for(int i=s+1; i<e; i++){
                    int myans = dp[s][i] + dp[i][e] + arr[s]*arr[i]*arr[e];
                    ans = Math.max(ans, myans);
                }
                dp[s][e] = ans;
            }
        }

        return dp[0][m-1];
    }
}