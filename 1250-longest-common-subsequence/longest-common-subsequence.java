class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row :dp){
            Arrays.fill(row, -1);
        }

        return helperdon(text1,n-1,text2,m-1,dp);
    }
    public int helperdon(String s1, int i, String s2, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            int x = helperdon(s1, i-1, s2, j-1, dp);
            dp[i][j] = x+1;
            return x+1;
        }
        else{
            int x = helperdon(s1, i-1, s2, j, dp);
            int y = helperdon(s1, i, s2, j-1, dp);
            dp[i][j] = Math.max(x, y);
            return Math.max(x, y);
        }
    }
}