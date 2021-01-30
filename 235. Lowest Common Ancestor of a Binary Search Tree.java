/* Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Solution 1: Faster that 53.1% Java submissions */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left_subtree, right_subtree;
        if (p.val < root.val || q.val < root.val) {
            left_subtree = lowestCommonAncestor(root.left, p, q);
        } else {
            left_subtree = null;
        }
        if (p.val > root.val || q.val > root.val) {
            right_subtree = lowestCommonAncestor(root.right, p, q);
        } else {
            right_subtree = null;
        }
        if (left_subtree != null && right_subtree == null) return left_subtree;
        if (left_subtree == null &&  right_subtree != null) return right_subtree;
        if (left_subtree != null &&  right_subtree != null) return root;
        return null;
    }
}

/*  Solution 2: Faster that 100% Java submissions */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
