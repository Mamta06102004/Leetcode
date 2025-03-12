class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstNonNegative(nums);
        int posCount = nums.length - findFirstPositive(nums);
        return Math.max(negCount, posCount);
    }

    // Finds the index of the first non-negative number (0 or positive)
    public int findFirstNonNegative(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;  // Move right if still negative
            } else {
                right = mid - 1; // Move left to find the first occurrence
            }
        }
        return left;
    }

    // Finds the index of the first positive number
    public int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) { 
                left = mid + 1;  // Move right if 0 or negative
            } else {
                right = mid - 1; // Move left to find the first occurrence
            }
        }
        return left;
    }
}