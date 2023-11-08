class Solution {
    class Route {
        int dst;
        int price;
        int rem;
        Route(int dst, int price, int rem) {
            this.dst = dst;
            this.price = price;
            this.rem = rem;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int[] flight : flights) {
            ArrayList list = map.getOrDefault(flight[0], new ArrayList<int[]>());
            list.add(new int[]{flight[1],flight[2]});
            map.put(flight[0], list);
        }
        if(map.get(src) == null) return -1;

        PriorityQueue<Route> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        int[] weight = new int[n];
        int[] rems = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[src] = 0;
        for(int[] route : map.get(src)) pq.add(new Route(route[0],route[1],k));
        while(!pq.isEmpty()) {
            Route cur = pq.poll();
            if(cur.dst == 1)System.out.println(cur.dst + " " + cur.rem + " " + cur.price);
            if(cur.dst == dst) return cur.price;
            if(cur.rem == 0 || map.get(cur.dst) == null) continue;
            weight[cur.dst] = cur.price;
            rems[cur.dst] = cur.rem;
            
            for(int[] flight : map.get(cur.dst)) {
                if((cur.rem == 1 && flight[0] != dst) || 
                    (weight[flight[0]] < flight[1] + cur.price && rems[flight[0]] > cur.rem - 1)) continue;
                pq.add(new Route(flight[0], cur.price + flight[1], cur.rem - 1));
            }
        }
        return -1;
    }
}