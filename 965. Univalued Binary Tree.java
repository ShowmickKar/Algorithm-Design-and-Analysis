/* Problem Link: https://leetcode.com/problems/univalued-binary-tree/

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
    HashSet<Integer> node_values = new HashSet<Integer>();
    public boolean isUnivalTree(TreeNode root) {
        traverse(root);
        return (node_values.size() == 1);
    }
    
    public void traverse(TreeNode node) {
        if (node == null || node_values.size() > 1) return;
        node_values.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}
