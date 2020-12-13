# Problem Link: https://leetcode.com/problems/symmetric-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Naive Solution:

class Solution:
    def checkPalindrome(self, arr):
        l, u = 0, len(arr) - 1
        while l < u:
            if arr[l] != arr[u]:
                return False
            l += 1
            u -= 1
        return True
    
    def preOdredTraversal(self, node, height):
        if not node:
            if height in self.level:
                self.level[height].append("!")
            else:
                self.level[height] = ["!"]
            return
        if height in self.level:
            self.level[height].append(node.val)
        else:
            self.level[height] = [node.val]    
        self.preOdredTraversal(node.left, height + 1)
        self.preOdredTraversal(node.right, height + 1)
        
    def isSymmetric(self, root: TreeNode) -> bool:
        self.level = {}
        self.preOdredTraversal(root, 0)
        print(self.level)
        for e in self.level:
            if not self.checkPalindrome(self.level[e]):
                return False
        return True
