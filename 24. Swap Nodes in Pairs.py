Problem Link: https://leetcode.com/problems/swap-nodes-in-pairs/
Difficulty: Medium

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head == None:
            return 
        
        current = head
        
        
        while current:
            try:
                current.val, current.next.val = current.next.val, current.val
            except:
                break
            current = current.next.next
            
        return head
