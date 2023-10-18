class Solution {
    ArrayList<List<Integer>> ans;
    int target;
    int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        this.target = target;
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                ArrayList<Integer> seq = new ArrayList<Integer>();
                seq.add(candidates[i]);
                dfs(candidates[i], i, seq);
            }
        }

        return ans;
    }

    private void dfs(int cur, int index, ArrayList<Integer> seq) {
        if(cur > target) return;
        if(cur == target) {
            ans.add((ArrayList<Integer>)seq.clone());
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            seq.add(candidates[i]);
            dfs(cur + candidates[i], i, seq);
            seq.remove((Integer)candidates[i]);
        }
    }
}