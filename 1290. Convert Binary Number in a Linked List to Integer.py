# Problem link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

# Runtime: 32 ms, faster than 50.47% of Python3 online submissions for Convert Binary Number in a Linked List to Integer.
# Memory Usage: 14.2 MB, less than 7.41% of Python3 online submissions for Convert Binary Number in a Linked List to Integer.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        retrive_binary = []
        
        current = head
        
        while current is not None:
            retrive_binary.append(current.val)
            current = current.next
            
        decimal_value = 0
        for i in range(len(retrive_binary)):
            decimal_value += retrive_binary[i] * math.pow(2, len(retrive_binary) - i - 1)
            
        return int(decimal_value)
