Problem Link: https://leetcode.com/problems/invert-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertBinaryTree(self, node):
        if not node:
            return 
        node.left, node.right = node.right, node.left
        self.invertBinaryTree(node.left)
        self.invertBinaryTree(node.right)
    
    def invertTree(self, root: TreeNode) -> TreeNode:
        self.invertBinaryTree(root)
        return root
