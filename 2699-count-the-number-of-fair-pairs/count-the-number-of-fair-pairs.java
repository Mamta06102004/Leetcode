class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = lowerBound(nums, lower - nums[i], i + 1);
            int right = upperBound(nums, upper - nums[i], i + 1);
            count += (right - left);
        }
        return count;
    }

    // Lower bound: first index >= target
    private int lowerBound(int[] nums, int target, int start) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Upper bound: first index > target
    private int upperBound(int[] nums, int target, int start) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}