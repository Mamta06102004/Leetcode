class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     if(n == 1 && m == 1){
    //         if(target == matrix[0][0]){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }
    //     if(n == 1){
    //         return BS(matrix, 0, m, target);
    //     }
    //     else if(m == 1){
    //         return BS(matrix, 0, n, target);
    //     }
    //     else{
    //         return BS(matrix, 0, m*n-1, target);
    //     }

    
    // }
    // public boolean BS(int[][] matrix, int low, int high, int target){
    //      int n = matrix.length;
    //     int m = matrix[0].length;
    //     int lo = low;
    //     int hi = high;
    //     while(lo <= hi){
    //         int mid = lo + (hi-lo)/2;
    //         int ridx = mid / m;
    //         int cidx = mid % m;
            
    //         if(target == matrix[ridx][cidx]){
    //             return true;
    //         }
    //         else if(target < matrix[ridx][cidx]){
    //             hi = m - 1;
    //         }
    //         else{
    //             lo = m + 1;
    //         }
    //     }
    //     return false;
    // }
      int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0, hi = n*m-1;
        while(lo<=hi){
           int mid = (lo+hi)/2;
            int r = mid/m;
            int c = mid%m;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) lo = mid+1;
            else hi = mid-1;
            
        }
        return false;
    }
}