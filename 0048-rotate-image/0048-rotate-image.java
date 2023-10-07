class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return;
        int lvl = 0;

        for(int row = 0; row < n / 2; row++) {
            for(int col = lvl; col < n-1-lvl; col++) {
                swap(matrix, row, col, n);
            }
            lvl++;
        }
    }
    
    private void swap(int[][] matrix, int row, int col, int n) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[n-1-col][row];
        matrix[n-1-col][row] = matrix[n-1-row][n-1-col];
        matrix[n-1-row][n-1-col] = matrix[col][n-1-row];
        matrix[col][n-1-row] = temp;
    }
}