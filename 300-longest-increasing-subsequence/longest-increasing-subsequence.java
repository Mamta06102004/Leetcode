class Solution {
    public int lengthOfLIS(int[] nums) {

        // NlogN approach

        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int lo = 0, hi = ans;
            while(lo < hi){
                int m = lo + (hi-lo)/2;
                if(dp[m] < nums[i]){
                    lo = m + 1;
                }
                else{               //dp[m] > nums[i]
                    hi = m;
                }
            }
            dp[lo] = nums[i];
            if(lo == ans){
                ans++;
            }
        }
        return ans;
    }
}