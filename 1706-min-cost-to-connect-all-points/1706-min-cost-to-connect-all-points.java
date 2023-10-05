class Solution {
    int best;

    class Node {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        best = Integer.MAX_VALUE;
        dijkstra(points,0);
        return best;
    }
    
    private void dijkstra(int[][] points, int index) {
        int curBest = 0;
        boolean[] visited = new boolean[points.length];
        int visits = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(index, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visits == points.length) break;
            if(visited[cur.index]) continue;
            visited[cur.index] = true;
            visits++;
            curBest += cur.cost;
            if(curBest > best) return;

            for(int i = 0; i < points.length; i++) {
                if (!visited[i] && cur.index != i) {
                    int dist = Math.abs(points[cur.index][0] - points[i][0]) + Math.abs(points[cur.index][1] - points[i][1]);
                    pq.add(new Node(i, dist));
                }
            }
        }
        best = curBest;
    }
}