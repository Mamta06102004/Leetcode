class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int m = lo + (hi-lo)/2;
            if(target == nums[m]){
                return true;
            }
            if(nums[lo] == nums[m] && nums[m] == nums[hi]){
                lo++; hi--;
            }
            else if(nums[m] <= nums[hi]){           //right side sorted
                if(target >= nums[m] && target <= nums[hi]){
                    lo = m + 1;
                }
                else{
                    hi = m - 1;
                }
            }
            else{                       //left part sorted
                if(target >= nums[lo] && target <= nums[m]){
                    hi = m - 1;
                }
                else{
                    lo = m + 1;
                }
            }
        }
        return false;
    }
}