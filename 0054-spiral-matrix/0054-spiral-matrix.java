class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = 0;
        int c = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> out = new ArrayList<>();
        while(r < matrix.length && r >= 0 && c < matrix[0].length && 
            c >= 0 && !visited[r][c]) {
            while(c < matrix[0].length && !visited[r][c]) {
                visited[r][c] = true;
                out.add(matrix[r][c]);
                c++;
            }
            c--;
            r++;
            while(r < matrix.length && !visited[r][c]) {
                visited[r][c] = true;
                out.add(matrix[r][c]);
                r++;
            }
            r--;
            c--;
            while(c >= 0 && !visited[r][c]) {
                visited[r][c] = true;
                out.add(matrix[r][c]);
                c--;
            }
            c++;
            r--;
            while(r >= 0 && !visited[r][c]) {
                visited[r][c] = true;
                out.add(matrix[r][c]);
                r--;
            }
            r++;
            c++;
        }
        return out;
    }
}