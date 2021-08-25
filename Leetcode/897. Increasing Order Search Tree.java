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
    TreeNode newRoot, cur;

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            if (newRoot == null) {
                newRoot = new TreeNode(root.val);
                cur = newRoot;
            } else {
                cur.right = new TreeNode(root.val);
                cur = cur.right;
            }
            inOrderTraversal(root.right);
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        newRoot = null;
        cur = null;
        inOrderTraversal(root);
        return newRoot;
    }
}
