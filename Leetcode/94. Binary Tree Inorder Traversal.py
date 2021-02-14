# Problemk link: https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, node):
        if not node:
            return
        self.traverse(node.left)
        self.ans.append(node.val)
        self.traverse(node.right)
        
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.ans = []
        self.traverse(root)
        return self.ans
