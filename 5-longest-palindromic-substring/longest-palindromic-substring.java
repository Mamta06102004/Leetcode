class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int sp = 0, maxlen = 1;
        boolean[][] dp = new boolean[n][n];

        for(int gap=0; gap<n; gap++){
            int i=0, j=gap;
            while(j<n){
                if(gap == 0){
                    dp[i][j] = true;
                }
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        maxlen = 2;
                        sp = i;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        if(j-i+1 > maxlen){
                            maxlen = j-i+1;
                        }
                        sp = i;
                    }
                }
                i++; j++;
            }
        }
        return s.substring(sp, sp+maxlen);
    }
}