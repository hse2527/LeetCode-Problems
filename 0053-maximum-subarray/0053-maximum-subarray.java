class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            if(temp + nums[i] > 0) {
                temp += nums[i];
                sum = (temp > sum) ? temp : sum;
            } else {
                temp = 0;
                if(sum <= 0) sum = (nums[i] > sum) ? nums[i] : sum;
            }
        }
        return sum;
    }
}