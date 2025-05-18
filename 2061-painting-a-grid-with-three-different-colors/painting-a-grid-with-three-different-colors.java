class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> validCols = new ArrayList<>();
        generateValidColumns(m, new int[m], 0, validCols);

        int len = validCols.size();

        // Map each valid column to its index
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(Arrays.toString(validCols.get(i)), i);
        }

        // Precompute transitions between valid columns
        List<Integer>[] transitions = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (isCompatible(validCols.get(i), validCols.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        // DP initialization
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        // Fill DP table
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j : transitions[i]) {
                    newDp[j] = (newDp[j] + dp[i]) % MOD;
                }
            }
            dp = newDp;
        }

        // Sum all possibilities for the last column
        int result = 0;
        for (int val : dp) {
            result = (result + val) % MOD;
        }

        return result;
    }

    // Generate all valid column colorings recursively
    private void generateValidColumns(int m, int[] current, int row, List<int[]> result) {
        if (row == m) {
            result.add(current.clone());
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (row == 0 || current[row - 1] != color) {
                current[row] = color;
                generateValidColumns(m, current, row + 1, result);
            }
        }
    }

    // Check if two columns can be adjacent
    private boolean isCompatible(int[] col1, int[] col2) {
        for (int i = 0; i < col1.length; i++) {
            if (col1[i] == col2[i]) return false;
        }
        return true;
    }
}