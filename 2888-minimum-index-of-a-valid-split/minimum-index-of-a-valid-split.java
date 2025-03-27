class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
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
        int totalOccurrences = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalOccurrences++;
            }
        }
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int rightCount = totalOccurrences - leftCount;
            int leftSize = i + 1, rightSize = n - leftSize;
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }
        return -1;
    }
}