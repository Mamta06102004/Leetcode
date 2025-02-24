class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi){
            int m = lo + (hi-lo)/2;
            ans = Math.min(ans, nums[m]);
            if(nums[m] <= nums[hi]){        //right side sorted
                hi = m - 1;
            }
            else{                           //left part sorted
                ans = Math.min(ans, nums[lo]);
                lo = m + 1;
            }
        }
        return ans;
    }
}