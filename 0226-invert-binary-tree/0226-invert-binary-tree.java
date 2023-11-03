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
    public TreeNode invertTree(TreeNode root) {
        TreeNode ret = root;
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left != null) {
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            } else {
                cur.left = cur.right;
                cur.right = null;
            }
            if(cur.left != null)q.add(cur.left);
            if(cur.right != null)q.add(cur.right);
        }
        return ret;
    }
}