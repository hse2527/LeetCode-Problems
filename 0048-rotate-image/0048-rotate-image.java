class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        int row = 0;
        int col = 0;
        for(int i = 0; i < n; i++) {
            row = n-1;
            for(int j = 0; j < n; j++) {
                ans[i][j] = matrix[row][col];
                row --;
            }
            col++;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}