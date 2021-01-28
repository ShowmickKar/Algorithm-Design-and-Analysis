# Problem Link: https://leetcode.com/problems/range-sum-of-bst/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse(self, node, low, high):
        if node == None:
            return 0
        sum = 0
        if node.val >= low and node.val <= high:
            sum += node.val
        if low < node.val:
            sum += self.traverse(node.left, low, high)
        if high > node.val:
            sum += self.traverse(node.right, low, high)
        return sum
            
        
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        return self.traverse(root, low, high)
