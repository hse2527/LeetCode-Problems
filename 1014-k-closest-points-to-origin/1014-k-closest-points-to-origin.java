class Solution {
    class Point {
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> pq = new PriorityQueue<>((a,b) -> b.distance - a.distance);
        for(int[] point : points) pq.add(new Point(point[0], point[1], point[0] * point[0] + point[1] * point[1]));
        while(pq.size() > k) pq.poll();
        int[][] ans = new int[k][2];
        for(int i = 0; !pq.isEmpty(); i++) {
            Point cur = pq.poll();
            ans[i] = new int[]{cur.x, cur.y};
        }
        return ans;
    }
}