class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int remaining = 0 - nums[i];
            l = i + 1;
            r = nums.length - 1;

            while(l < r) {
                if(nums[l] + nums[r] > remaining) r--;
                if(nums[l] + nums[r] < remaining) l++;
                if(l == r) break;
                if(nums[l] + nums[r] == remaining) {
                    if(set.add(hash(new Integer[]{nums[l], nums[i], nums[r]}))) {
                        ans.add(Arrays.asList(new Integer[]{nums[l], nums[i], nums[r]}));
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