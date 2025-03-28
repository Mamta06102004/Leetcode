class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dP = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0){
                    dP[i][j] = 1;
                }
                else{
                    dP[i][j] = dP[i-1][j] + dP[i][j-1];
                }
            } 
        }
        return dP[m-1][n-1];
    }
}