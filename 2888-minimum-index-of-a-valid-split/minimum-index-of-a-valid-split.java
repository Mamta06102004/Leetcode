class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        // Step 1: Find the dominant element using Boyer-Moore Voting Algorithm
        int candidate = nums.get(0), count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = num;
                    count = 1;
                }
            }
        }

        // Step 2: Count occurrences of the dominant element
        int totalOccurrences = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalOccurrences++;
            }
        }

        // Step 3: Find the minimum valid split index
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }

            int rightCount = totalOccurrences - leftCount;
            int leftSize = i + 1, rightSize = n - leftSize;

            // Check if candidate is dominant in both partitions
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}