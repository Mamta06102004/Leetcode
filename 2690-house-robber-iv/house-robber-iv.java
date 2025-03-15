class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canRob(nums, k, mid)) {
                right = mid; // Try for a smaller max capability
            } else {
                left = mid + 1; // Increase the min capability
            }
        }
        
        return left;
    }
    
    public boolean canRob(int[] nums, int k, int capability) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i++; // Skip the adjacent house
            }
            i++; // Move to the next house
        }
        
        return count >= k;
    }
}