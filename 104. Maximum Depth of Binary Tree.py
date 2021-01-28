# Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, node, height, current_maximum):
        if not node:
            return max(height, current_maximum)
        return max(self.traverse(node.left, height + 1, current_maximum), self.traverse(node.right, height + 1, current_maximum))
        
            
    def maxDepth(self, root: TreeNode) -> int:
        return self.traverse(root, 0, 0)
