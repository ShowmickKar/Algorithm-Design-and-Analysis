# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        node1, node2 = headA, headB
        length1, length2 = 0, 0
        
        while node1:
            node1 = node1.next
            length1 += 1
        while node2:
            node2 = node2.next
            length2 += 1
            
        node1, node2 = headA, headB
        
        if length2 > length1:
            node1, node2 = node2, node1
            length1, length2 = length2, length1
        
        pointer1, pointer2 = 0, 0
        
        while node1:
            if length1 - pointer1 == length2:
                break
            node1 = node1.next
            pointer1 += 1
        
        while node1:
            if node1 == node2:
                return node1
            node1 = node1.next
            node2 = node2.next
