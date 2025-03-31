class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] adjacentSums = new int[n - 1];

        // Step 1: Compute sums of adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            adjacentSums[i] = weights[i] + weights[i + 1];
        }

        // Step 2: Sort the adjacent sums
        Arrays.sort(adjacentSums);

        long minSum = 0, maxSum = 0;

        // Step 3: Compute the minimum sum using the smallest (k-1) adjacent sums
        for (int i = 0; i < k - 1; i++) {
            minSum += adjacentSums[i];
        }

        // Step 4: Compute the maximum sum using the largest (k-1) adjacent sums
        for (int i = n - 2; i >= n - k; i--) {
            maxSum += adjacentSums[i];
        }

        // Step 5: Return the difference
        return maxSum - minSum;
    }
}