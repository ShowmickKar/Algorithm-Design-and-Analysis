// Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    public int dfs(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
}
