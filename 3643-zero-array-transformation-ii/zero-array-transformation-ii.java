class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        
        // If nums is already a zero array, return 0 immediately
        boolean alreadyZero = true;
        for (int num : nums) {
            if (num != 0) {
                alreadyZero = false;
                break;
            }
        }
        if (alreadyZero) return 0;
        
        int left = 1, right = m, ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canMakeZero(nums.clone(), queries, mid)) {
                ans = mid;
                right = mid - 1; // Try for a smaller k
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // Difference array to track range updates
        
        // Apply the first k queries using difference array
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], v = queries[i][2];
            diff[l] += v;
            if (r + 1 < n) diff[r + 1] -= v;
        }
        
        int decrement = 0; // Running prefix sum for applying difference array
        
        for (int i = 0; i < n; i++) {
            decrement += diff[i];
            
            if (nums[i] > decrement) {
                // If we need to decrement more than available, it's impossible
                return false;
            }
            
            nums[i] -= Math.min(nums[i], decrement);
        }
        
        // Check if the entire array is zero
        for (int num : nums) {
            if (num != 0) return false;
        }
        
        return true;
    }
}