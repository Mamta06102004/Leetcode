class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b)-> Integer.compare(b[0], a[0]));
        int[] parenta = new int[n+1];
        int[] parentb = new int[n+1];
        int[] ranka = new int[n+1];
        int[] rankb = new int[n+1];

        for(int i=1; i<=n; i++){
            parenta[i] = parentb[i] = i;
            ranka[i] = rankb[i] = 1;
        }

        int ans = 0, counta = 1, countb = 1;
        for(int i=0; i<edges.length; i++){
            int cat = edges[i][0];
            int x = edges[i][1];
            int y = edges[i][2];

            if(cat == 3){
                boolean merga = union(x, y, parenta, ranka);
                boolean mergb = union(x, y, parentb, rankb);
                if(merga == false && mergb == false){
                    ans++;
                }
                if(merga == true) counta++;
                if(mergb == true) countb++;

            }
            else if(cat == 2){
                boolean mergb = union(x, y, parentb, rankb);
                if(mergb == false){
                    ans++;
                }
                else{
                    countb++;
                }
            }
            else{
                boolean merga = union(x, y, parenta, ranka);
                if(merga == false){
                    ans++;
                }
                else{
                    counta++;
                }
            }
        }
        if(counta != n || countb != n) return -1;
        return ans;
    }
    public boolean union(int x, int y, int[] parent, int[] rank){
        int px = find(x, parent);
        int py = find(y, parent);
        if(px == py) return false;
        if(rank[px] >  rank[py]){
            parent[py] = px;
        }
        else if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
    public int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
}