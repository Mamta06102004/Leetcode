class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / m;
            int c = mid % m;
            if (matrix[r][c] == target){

            
                return true;
            }
            else if (matrix[r][c] > target){

                hi = mid - 1;
            }
            else{

                lo = mid + 1;
            }

        }
        return false;
    }
}