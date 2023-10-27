class Solution {
    public int maxArea(int[] height) {
        int a = 0; 
        int b = height.length - 1;
        int max = 0;

        while(a < b) {
            max = Math.max(Math.min(height[a], height[b]) * (b - a),max);
            if(height[a] > height[b]) b--;
            else a++;
        }
        return max;
    }
}