class Solution {
    
    private List<Integer>[] graph;
    private int[] bobPath;
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        graph = new ArrayList[n];
        bobPath = new int[n];
        Arrays.fill(bobPath, -1);

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        findBobPath(bob, -1, 0);
        dfs(0, -1, 0, 0, amount);

        return maxIncome;
    }

    private boolean findBobPath(int node, int parent, int steps) {
        bobPath[node] = steps;
        if (node == 0) return true;

        for (int neighbor : graph[node]) {
            if (neighbor != parent && findBobPath(neighbor, node, steps + 1)) return true;
        }

        bobPath[node] = -1;
        return false;
    }

    private void dfs(int node, int parent, int steps, int income, int[] amount) {
        if (bobPath[node] == -1 || steps < bobPath[node]) {
            income += amount[node];
        } else if (steps == bobPath[node]) {
            income += amount[node] / 2;
        }

        if (graph[node].size() == 1 && node != 0) {
            maxIncome = Math.max(maxIncome, income);
            return;
        }

        for (int neighbor : graph[node]) {
            if (neighbor != parent) dfs(neighbor, node, steps + 1, income, amount);
        }
    }
    
}