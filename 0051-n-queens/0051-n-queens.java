class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        dfs(new int[n], new boolean[n], n, 0, out);
        return out;
    }

    private void dfs(int[] queens, boolean[] possible, int c, int r, List<List<String>> out) {
        if(c == 0) {
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < queens.length; i++) {
                String str = "";
                for(int j = 0; j < queens[i]; j++) {
                    str += '.';
                }
                str += 'Q';
                for(int j = queens[i] + 1; j < queens.length; j++) {
                    str += '.';
                }
                cur.add(str);
            }
            out.add(cur);
            return;
        }
        for(int i = 0; i < possible.length; i++) {
            if(possible[i]) continue;
            boolean pos = true;
            for(int j = 0; j < r; j++){
                if(i == queens[j] || i == queens[j] - (r - j) || i == queens[j] + (r - j)) {
                    pos = false;
                    break;
                }
            }
            if(pos) {
                queens[r] = i;
                possible[i] = true;
                dfs(queens, possible, c - 1, r + 1, out);
                possible[i] = false;
            }
        }
    }
}