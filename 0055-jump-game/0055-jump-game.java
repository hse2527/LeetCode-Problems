class Solution {
    public boolean canJump(int[] nums) {
        int c = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            c++;
            if(nums[i] >= c) c = 0;
        }
        return c == 0;
    }
}