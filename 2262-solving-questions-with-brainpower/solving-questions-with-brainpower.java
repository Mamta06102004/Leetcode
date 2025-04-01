class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
        
    }
    public long helper(int[][] que, int i, long[] dp){
        if(i >= que.length){
            return 0L;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int points = que[i][0];
        int brainpower = que[i][1];
        int nextque = i + brainpower + 1;

        long skip = helper(que,i+1,dp);        
        long solve = helper(que,nextque,dp); 

        dp[i] = Math.max(skip, solve+points);
        return Math.max(skip, solve+points);        

    }
}