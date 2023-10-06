class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        boolean started = false;
        boolean added = false;
        List<int[]> list = new ArrayList<>();

        if(intervals.length == 0) return new int[][]{newInterval};

        for (int i = 0; i < intervals.length; i++) {
            if(!added && !started && ((intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1])
                || (intervals[i][0] <= newInterval[1] && intervals[i][0] >= newInterval[0]))) {
                start = Math.min(intervals[i][0], newInterval[0]);
                end = Math.max(intervals[i][1], newInterval[1]);
                started = true;
            } else if(started && end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], newInterval[1]);
            } else if(started && end < intervals[i][0]) {
                list.add(new int[] {start,end});
                list.add(intervals[i]);
                started = false;
                added = true;
            } else if (!added && !started && intervals[i][0] > newInterval[1]) {
                list.add(newInterval);
                list.add(intervals[i]);
                added = true;
            } else {
                list.add(intervals[i]);
                if(intervals[i][1] > newInterval[1]) added = true;
            }
        }
        if(!added) list.add(new int[] {start,end});
        int[][] ans = new int[list.size()][2];
        int index = 0;
        for(int[] interval : list) {
            ans[index] = interval;
            index++;
        }
        return ans;
    }
}