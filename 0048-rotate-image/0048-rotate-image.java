class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return;
        Integer temp = 0;
        int lvl = 0;

        for(int row = 0; row < n / 2; row++) {
            for(int col = lvl; col < n-1-lvl; col++) {
                swap(matrix, row, col, n, temp);
            }
            lvl++;
        }
    }
    
    private void swap(int[][] matrix, int row, int col, int n, Integer temp) {
        temp = matrix[row][col];
        matrix[row][col] = matrix[n-1-col][row];
        matrix[n-1-col][row] = matrix[n-1-row][n-1-col];
        matrix[n-1-row][n-1-col] = matrix[col][n-1-row];
        matrix[col][n-1-row] = temp;
    }
}