class Solution {
    public int findMin(int[] nums) {
        // int lo = 0;
        // int hi = nums.length-1;
        // int ans = Integer.MAX_VALUE;

        // while(lo <= hi){
        //     int m = lo +(hi-lo)/2;
        //     ans = Math.min(ans, nums[m]);
        //     if(lo == m && m == hi){
        //         return ans;
        //     }
        //     if(nums[lo] == nums[m] && nums[m] == nums[hi]){
        //         lo++; hi--;
        //     }
        //     if(nums[m] <= nums[hi]){ 
        //         ans = Math.min(ans, nums[m]);           //right sorted
        //         hi = m - 1;
        //     }
        //     else{               //left sorted
        //         ans = Math.min(ans, nums[lo]);
        //         lo = m + 1;
        //     }
        // }
        // return ans;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int m = lo + (hi - lo) / 2;

            if (nums[m] > nums[hi]) { 
                // Minimum must be in the right half
                lo = m + 1;
            } 
            else if (nums[m] < nums[hi]) {
                // Minimum must be in the left half
                hi = m;
            } 
            else {
                // nums[m] == nums[hi], we can't decide, so reduce search space
                hi--;
            }
        }
        return nums[lo];
    }
}