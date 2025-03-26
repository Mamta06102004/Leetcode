class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> flatList = new ArrayList<>();

        // Check if all elements have the same remainder modulo x
        int remainder = grid[0][0] % x;
        for (int[] row : grid) {
            for (int value : row) {
                if (value % x != remainder) {
                    return -1; // Not possible to make the grid uni-value
                }
                flatList.add(value);
            }
        }

        // Sort the flattened list to find the median
        Collections.sort(flatList);
        int median = flatList.get(flatList.size() / 2);

        // Calculate the minimum operations required to make all elements equal to the median
        int minOperations = 0;
        for (int value : flatList) {
            minOperations += Math.abs(value - median) / x;
        }

        return minOperations;
    }
}