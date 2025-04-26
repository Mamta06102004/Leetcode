class Solution {
    int parent[];
    int rank[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) ans++;
        }
        return ans;

    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        if(rank[px] > rank[py]){
            parent[py] = px;
        }
        else if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;
        }
    }
    public int find(int x){
        if(parent[x] == x) return x;

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
   
}