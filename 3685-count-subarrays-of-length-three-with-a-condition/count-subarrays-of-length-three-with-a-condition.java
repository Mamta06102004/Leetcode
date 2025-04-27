class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-2; i++){
            int l = nums[i];
            int m = nums[i+1];
            int r = nums[i+2];
            if(l+r == m/2.0){
                count++;
            }
        }
        return count;
    }
}