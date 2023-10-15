/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return ans;
        dfs(root,0);
        return ans;
    }

    private int dfs(TreeNode cur, int depth) {
        if(cur.left == null && cur.right == null) {
            return depth;
        }
        int left = (cur.left != null) ? dfs(cur.left, depth+1) : depth;
        int right = (cur.right != null) ? dfs(cur.right, depth+1) : depth;
        if(Math.abs(left - right) > 1) ans = false;
        return Math.max(left, right);
    } 
}