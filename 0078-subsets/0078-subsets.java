class Solution {
    
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        getSubSets(nums, new ArrayList<Integer>(), -1);
        return ans;
    }

    private void getSubSets(int[] nums, ArrayList<Integer> cur, int index) {
        ans.add((ArrayList)cur.clone());
        for(int i = index + 1; i < nums.length; i++) {
            cur.add(nums[i]);
            getSubSets(nums, cur, i);
            cur.remove(new Integer(nums[i]));
        }
    }
}