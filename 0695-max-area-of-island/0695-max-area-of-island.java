class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }

    public int dfs (int[][] grid, int x, int y) {
        grid[x][y] = 0;
        int max = 1;
        for(int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if(newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 1) {
                max += dfs(grid, newx, newy);
            }
        }
        return max;
    }
}