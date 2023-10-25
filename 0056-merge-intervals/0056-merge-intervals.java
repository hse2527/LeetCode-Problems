class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o-> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int outCount = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end) end = Math.max(end,intervals[i][1]);
            else {
                intervals[outCount][0] = start;
                intervals[outCount][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                outCount++;
            }
        }
        intervals[outCount][0] = start;
        intervals[outCount][1] = end;
        outCount++;
        int[][] ans = new int[outCount][2];
        for(int i = 0; i < outCount; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }
}