/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    boolean[][] visited = new boolean[101][101];
    Node[] visitedNodes = new Node[101];
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node newNode = new Node(node.val);
        visitedNodes[node.val] = newNode;
        dfs(node, newNode, 1);
        return newNode;
    }

    private void dfs(Node orig, Node newNode, int prev) {
        visited[prev][orig.val] = true;
        for(Node next : orig.neighbors) {
            if(visited[orig.val][next.val]) continue;
            Node newNext;
            if(visitedNodes[next.val] == null) {
                newNext = new Node(next.val);
                visitedNodes[next.val] = newNext;
            } else {
                newNext = visitedNodes[next.val];
            }
            newNode.neighbors.add(newNext);
            dfs(next, newNext, orig.val);
        }
    }
}