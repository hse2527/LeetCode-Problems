class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int remaining = 0 - nums[i];
            l = i + 1;
            r = nums.length - 1;

            while(l < r) {
                Integer[] triplet = {nums[l], nums[i], nums[r]};
                if(nums[l] + nums[r] > remaining) r--;
                else if(nums[l] + nums[r] < remaining) l++;
                else {
                    if(set.add(hash(triplet))) {
                        ans.add(Arrays.asList(triplet));
                    }
                    l++;
                } 
            }
        }
        return ans;
    }
    private String hash(Integer[] triplet) {
        return "" + triplet[0] + triplet[1] + triplet[2];
    }
}