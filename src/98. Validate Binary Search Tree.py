Problem Link: https://leetcode.com/problems/validate-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import math

class Solution:
    def validateBinarySearchTree(self, node, current_range):
        if node == None:
            return True
        if node.val <= current_range[0] or node.val >= current_range[1]:
            return False
        return self.validateBinarySearchTree(node.left, [current_range[0], node.val]) and self.validateBinarySearchTree(node.right, [node.val, current_range[1]])
        
        
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validateBinarySearchTree(root, [-math.inf, math.inf])
