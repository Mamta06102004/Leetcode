class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];
        
        int[][] queryWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queryWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[] directions = {-1, 0, 1, 0, -1}; // For moving in 4 directions
        int count = 0, index = 0;
        
        while (index < queries.length) {
            int queryVal = queryWithIndex[index][0];
            int originalIndex = queryWithIndex[index][1];
            
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                count++;
                for (int d = 0; d < 4; d++) {
                    int nr = r + directions[d];
                    int nc = c + directions[d + 1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            result[originalIndex] = count;
            index++;
        }
        return result;
    }
}