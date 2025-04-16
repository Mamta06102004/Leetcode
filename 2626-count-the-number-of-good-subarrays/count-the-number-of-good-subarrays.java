class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long countPairs = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add nums[right] to window
            int currFreq = freq.getOrDefault(nums[right], 0);
            countPairs += currFreq; // This many new pairs with nums[right]
            freq.put(nums[right], currFreq + 1);

            // Shrink the window from the left while it has at least k pairs
            while (countPairs >= k) {
                result += (nums.length - right); // All subarrays [left...right], [left+1...right], ... are valid
                int leftFreq = freq.get(nums[left]);
                freq.put(nums[left], leftFreq - 1);
                countPairs -= (leftFreq - 1); // Removing one element reduces these many pairs
                left++;
            }
        }

        return result;
    }
}