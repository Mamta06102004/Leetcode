class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int dominantElement = -1, totalOccurrences = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() * 2 > n) { // Check if it is dominant
                dominantElement = entry.getKey();
                totalOccurrences = entry.getValue();
                break;
            }
        }
        int f1 = 0; // Frequency of dominantElement in left partition
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominantElement) {
                f1++;
            }
            int f2 = totalOccurrences - f1; // Frequency in right partition
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            if (f1 * 2 > leftSize && f2 * 2 > rightSize) {
                return i;
            }
        }
        return -1;
    }
}