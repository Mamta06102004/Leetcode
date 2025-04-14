class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for(int gap=0; gap<n; gap++){
            int i=0, j=gap;
            while(j<n){
                if(gap == 0){
                    dp[i][j] = true;
                    count++;
                }
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        count++;
                    }
                }
                i++; j++;
            }
        }
        return count;
    }
}