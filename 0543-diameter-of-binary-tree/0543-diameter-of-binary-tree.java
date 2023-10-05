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
    
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestLeaf(root);
        return max;
    }
    
    private int longestLeaf(TreeNode root) {
        if(root == null) return 0;
        int l = longestLeaf(root.left);
        int r = longestLeaf(root.right);
        max = Math.max(max, l + r);
        return ((l > r) ? l : r) + 1;
    }
}