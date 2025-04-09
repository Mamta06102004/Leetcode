class Solution {
    public int maxCoins(int[] nums) {
        // RESCURSIVE APPROACH

        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int i=0; i<n; i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return maxdon(arr, 0, arr.length-1, dp);
    }

    public int maxdon(int[] arr, int s, int e, int[][] dp){
        if(s+1 >= e) return 0;

        if(dp[s][e] != -1) return dp[s][e];

        int ans = Integer.MIN_VALUE;
        for(int i=s+1; i<e; i++){
            int leftdon = maxdon(arr, s, i, dp);
            int rightdon = maxdon(arr, i, e, dp);

            int myans = leftdon + rightdon + arr[s]*arr[i]*arr[e];
            ans = Math.max(ans, myans);
        }
        dp[s][e] = ans;
        return ans;
    }
}