Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        list_length = 0
        
        current = head
        
        while current is not None:
            current = current.next
            list_length += 1
            
        list_length //= 2
        
        index = 0
        
        current = head
        
        while current is not None:
            if index == list_length:
                return current
            current = current.next
            index += 1
