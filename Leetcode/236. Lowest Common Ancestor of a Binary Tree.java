/* Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left_subtree = lowestCommonAncestor(root.left, p, q);
        TreeNode right_subtree = lowestCommonAncestor(root.right, p, q);
        if (left_subtree == null && right_subtree != null) {
            return right_subtree;
        }
        if (left_subtree != null && right_subtree == null) {
            return left_subtree;
        }
        if (left_subtree != null && right_subtree != null) {
            return root;
        }
        return null;
    }
}
