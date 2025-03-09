class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] isAlternating = new int[n];
        
        // Precompute alternating information
        for (int i = 0; i < n; i++) {
            isAlternating[i] = (colors[i] != colors[(i + 1) % n]) ? 1 : 0;
        }

        int alternatingCount = 0;
        for (int i = 0; i < k - 1; i++) {
            alternatingCount += isAlternating[i];
        }

        int count = (alternatingCount == k - 1) ? 1 : 0;

        // Sliding window over the circular array
        for (int i = 1; i < n; i++) {
            alternatingCount -= isAlternating[i - 1];
            alternatingCount += isAlternating[(i + k - 2) % n];

            if (alternatingCount == k - 1) {
                count++;
            }
        }

        return count;
    }
}