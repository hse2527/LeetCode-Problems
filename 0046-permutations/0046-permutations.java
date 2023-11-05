class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<Integer>(), new boolean[nums.length]);
        return list;
    }

    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> cur, boolean[] visited) {
        if(cur.size() == nums.length) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, list, cur, visited);
            visited[i] = false;
            cur.remove((Integer)nums[i]);
        }
    }
}