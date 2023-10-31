class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, mid = 0;
        int r = matrix.length;
        while(l < r) {
            mid = (l + r) / 2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) break;
            if(matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int row = mid;
        l = 0;
        r = matrix[0].length;
        mid = 0;
        while(l < r) {
            mid = (l + r) / 2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[row][mid] == target;
    }
}