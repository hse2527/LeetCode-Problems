class Solution {
    class Point {
        int val;
        int weight;
        Point (int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = -1;
        HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
        boolean[] visited = new boolean[n + 1];

        for(int[] edge : times) {
            ArrayList<Point> cur = map.getOrDefault(edge[0], new ArrayList<>());
            cur.add(new Point(edge[1], edge[2]));
            map.put(edge[0], cur);
        }

        Queue<Point> pq = new PriorityQueue<Point>((a,b) -> a.weight - b.weight);
        pq.add(new Point(k,0));

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            if(visited[cur.val]) continue;
            n--;
            if(n == 0) ans = cur.weight;
            visited[cur.val] = true;
            ArrayList<Point> list = map.get(cur.val);
            if(list == null) continue;
            for(Point pt : list) {
                if(visited[pt.val]) continue;
                pq.add(new Point(pt.val, pt.weight + cur.weight));
            }
        }

        return ans;
    }
}