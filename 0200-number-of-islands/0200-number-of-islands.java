class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    DFS(grid, i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void DFS(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if(newi >= 0 && newi < grid.length 
                && newj >= 0 && newj < grid[0].length
                && grid[newi][newj] == '1') DFS(grid,newi,newj);
        }
    }
}