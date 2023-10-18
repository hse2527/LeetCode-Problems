class Solution {
    ArrayList<List<Integer>> ans;
    HashSet<String> set;
    int target;
    int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        set = new HashSet<String>();
        this.target = target;
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                ArrayList<Integer> seq = new ArrayList<Integer>();
                seq.add(candidates[i]);
                dfs(candidates[i], "" + candidates[i], i, seq);
            }
        }

        return ans;
    }

    private void dfs(int cur, String comb, int index, ArrayList<Integer> seq) {
        if(cur > target) return;
        if(cur == target) {
            if(set.add(comb)) ans.add((ArrayList<Integer>)seq.clone());
        }
        for(int i = index; i < candidates.length; i++) {
            seq.add(candidates[i]);
            dfs(cur + candidates[i], comb + candidates[i], i, seq);
            seq.remove((Integer)candidates[i]);
        }
    }
}