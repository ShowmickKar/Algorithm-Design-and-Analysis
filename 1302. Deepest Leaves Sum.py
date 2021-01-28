Problem Link: https://leetcode.com/problems/deepest-leaves-sum/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, node, height):
        if not node:
            return
        if not node.left and not node.left:
            if self.max_depth == height:
                self.sum += node.val
            elif height > self.max_depth:
                self.sum = node.val
                self.max_depth = height
        self.traverse(node.left, height + 1)
        self.traverse(node.right, height + 1)
    
    def deepestLeavesSum(self, root: TreeNode) -> int:
        self.max_depth = 0
        self.level = {}
        self.sum = 0
        self.traverse(root, 0)
        return self.sum
