class Solution {
    boolean[] possible;
    List<int[]> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        dfs(new int[n], new boolean[n], n, 0);

        for(int[] in : ans) {
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < in.length; i++) {
                String str = "";
                for(int j = 0; j < n; j++) {
                    if(in[i] == j) str += 'Q';
                    else str += '.';
                }
                cur.add(str);
            }
            out.add(cur);
        }
        return out;
    }

    private void dfs(int[] queens, boolean[] possible, int c, int r) {
        if(c == 0) {
            ans.add(queens);
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
                int[] newArr = queens.clone();
                boolean[] newPos = possible.clone();
                newArr[r] = i;
                newPos[i] = true;
                dfs(newArr, newPos, c - 1, r + 1);
            }
        }
    }
}