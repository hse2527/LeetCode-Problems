class Solution {
    ArrayList<List<Integer>> ans;
    int target;
    int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        this.target = target;
        this.candidates = candidates;

        Arrays.sort(this.candidates);
        dfs(0, 0, new ArrayList<Integer>());

        return ans;
    }

    private void dfs(int cur, int index, ArrayList<Integer> seq) {
        if(cur == target) {
            ans.add((ArrayList<Integer>)seq.clone());
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(cur + candidates[i] > target) return;
            seq.add(candidates[i]);
            dfs(cur + candidates[i], i, seq);
            seq.remove((Integer)candidates[i]);
        }
    }
}