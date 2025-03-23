class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                if (isCompleteComponent(i, adj, visited, component)) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }
    private boolean isCompleteComponent(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            component.add(curr);
            
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        // Check if the component is complete
        int size = component.size();
        for (int v : component) {
            if (adj.get(v).size() != size - 1) {
                return false;
            }
        }
        
        return true;
    }
}