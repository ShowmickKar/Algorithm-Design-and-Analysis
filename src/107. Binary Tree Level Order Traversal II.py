# Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    levels = {}
    @classmethod
    def levelOrderTraversal(cls, node, depth):
        if node == None:
            return 
        if depth in cls.levels:
            cls.levels[depth].append(node.val)
        else:
            cls.levels[depth] = [node.val]
        cls.levelOrderTraversal(node.left, depth + 1)
        cls.levelOrderTraversal(node.right, depth + 1)
        
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        Solution.levelOrderTraversal(root, 0)
        ans = []
        for key in Solution.levels:
            ans.append(Solution.levels[key])
        Solution.levels = {}
        ans.reverse()
        return ans
