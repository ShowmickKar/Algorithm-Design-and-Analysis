// Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    ArrayList<Integer> store = new ArrayList<Integer>();

    public void traverse(TreeNode node) {
        if (node == null)
            return;
        store.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        traverse(root);
        HashSet<Integer> s = new HashSet<Integer>();
        for (int node : store) {
            if (s.contains(k - node)) {
                store.clear();
                return true;
            }
            s.add(node);
        }
        store.clear();
        return false;
    }
}
