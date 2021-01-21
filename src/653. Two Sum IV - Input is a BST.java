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

/* Solution 1: Using HashSet */
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

/* Solution 2: Using Inorder Traversal(Faster then 98.11% Solution) */

class Solution {
    private void inorderTraversal(TreeNode node, ArrayList<Integer> helper) {
        if (node == null)
            return;
        inorderTraversal(node.left, helper);
        helper.add(node.val);
        inorderTraversal(node.right, helper);
    }

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> helper = new ArrayList<Integer>();
        inorderTraversal(root, helper);
        int l = 0, u = helper.size() - 1;
        while (l < u) {
            if (helper.get(l) + helper.get(u) == k) {
                return true;
            }
            if (helper.get(l) + helper.get(u) < k)
                ++l;
            if (helper.get(l) + helper.get(u) > k)
                --u;
        }
        return false;
    }
}
