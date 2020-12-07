# Problem link: https://leetcode.com/problems/merge-two-sorted-lists/

# Solution with additional memory

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        list1 = []
        list2 = []
        
        current = l1
        
        while current is not None:
            list1.append(current.val)
            current = current.next
            
        current = l2
        
        while current is not None:
            list2.append(current.val)
            current = current.next
            
        final_list = [None] * (len(list1) + len(list2))
        
        i = 0
        j = 0
        k = 0
        
        while k < len(final_list):
            if j >= len(list2):
                final_list[k] = list1[i]
                i += 1
            elif i >= len(list1):
                final_list[k] = list2[j]
                j += 1
            elif list1[i] <= list2[j]:
                final_list[k] = list1[i]
                i += 1
            else:
                final_list[k] = list2[j]
                j += 1
            k += 1
        
        merged_list_node = ListNode()
           
        index = 0
        
        temp = merged_list_node
        
        while index < len(final_list):
            temp.next = ListNode(final_list[index])
            temp = temp.next
            index += 1
            
        return merged_list_node.next
        
# Solution without any additional memory (Faster then 99% submission)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        final_list = ListNode()
        
        copy = final_list
        
        while l1 != None and l2 != None:
            if l1.val <= l2.val:
                copy.next = ListNode(l1.val)
                l1 = l1.next
            else:
                copy.next = ListNode(l2.val)
                l2 = l2.next
            copy = copy.next
            
        if l1 != None:
            copy.next = l1
        else:
            copy.next = l2
            
        return final_list.next
