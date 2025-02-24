class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int m = lo + (hi-lo)/2;
            if(nums[m] == target){
                return m;
            }

            else if(nums[m] <= nums[hi]){                    //right part sorted
                if(target >= nums[m] && target <= nums[hi]){
                    lo = m + 1;
                }
                else{
                    hi = m - 1;
                }
            }
            else{                                       //left part sorted
                if(target >= nums[lo] && target <= nums[m]){
                    hi = m - 1;
                }
                else{
                    lo = m + 1;
                }
            }
        }
        return -1;
    }
}