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
    boolean flag = false;

    public void traverse(TreeNode node, int target, HashSet<Integer> s) {
        if (node == null)
            return;
        if (s.contains(target - node.val)) {
            flag = true;
            return;
        }
        s.add(node.val);
        traverse(node.left, target, s);
        traverse(node.right, target, s);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> s = new HashSet<Integer>();
        traverse(root, k, s);
        if (flag) {
            flag = false;
            return true;
        }
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
