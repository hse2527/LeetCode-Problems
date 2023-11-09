class Solution {
    HashSet<String> set = new HashSet();
    List<String> ans = new ArrayList();
    int lim;

    public List<String> generateParenthesis(int n) {
        int opens = n;
        int closes = n;
        lim = 2*n;
        recursivef(opens, closes, "");
        return ans;
    }

    public void recursivef(int opens, int closes, String cur) {
        if(cur.length() == lim) {
            // if(!set.contains(cur)) {
                set.add(cur);
                ans.add(cur);
            // }
            return;
        }
        if(cur.length() == 0) {
            recursivef(opens - 1, closes, cur + "(");
        } else {
            if (opens > 0) recursivef(opens - 1, closes, cur + "(");
            if ((closes > 1 || cur.length() == lim - 1) 
                && opens < closes) {
                recursivef(opens, closes - 1, cur + ")");
            }
        }
        
    }
}