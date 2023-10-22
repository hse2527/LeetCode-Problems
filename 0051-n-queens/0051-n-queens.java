class Solution {
    boolean[] possible;
    List<List<String>> out = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(new int[n], new boolean[n], n, 0);
        return out;
    }

    private void dfs(int[] queens, boolean[] possible, int c, int r) {
        if(c == 0) {
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < queens.length; i++) {
                String str = "";
                for(int j = 0; j < queens.length; j++) {
                    if(queens[i] == j) str += 'Q';
                    else str += '.';
                }
                cur.add(str);
            }
            out.add(cur);
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