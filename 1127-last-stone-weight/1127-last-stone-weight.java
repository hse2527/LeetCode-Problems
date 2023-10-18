class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            if(a == b) continue;
            pq.add(a - b);
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}