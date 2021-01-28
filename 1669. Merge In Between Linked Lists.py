# Problem Link: https://leetcode.com/problems/merge-in-between-linked-lists/

# Problem Statement: You are given two linked lists: list1 and list2 of sizes n and m respectively.

#                   Remove list1's nodes from the ath node to the bth node, and put list2 in their place.



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        current = list1
        index = 0
        
        while current is not None:
            if index == b:
                if current.next == None:
                    pass
                else:
                    intermediate_node = list2
                    while intermediate_node != None:
                        if intermediate_node.next == None:
                            intermediate_node.next = current.next
                            break
                        intermediate_node = intermediate_node.next
                break      
            index += 1
            current = current.next
        
        if a == 0:
            return list2
        current = list1
        index = 0
        
        while current is not None:
            if index == a - 1:
                current.next = list2
                return list1
            current = current.next
            index += 1
