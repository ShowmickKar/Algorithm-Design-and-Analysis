/* Problem Link: https://leetcode.com/problems/palindrome-linked-list/ */

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head):
        prev = None
        after = None
        current = head
        dummy = None
        while current:
            dummy = current
            after = current.next
            current.next = prev
            prev = current
            current = after
        return dummy
            
    def isPalindrome(self, head: ListNode) -> bool:
        second_half = None
        length = 0
        current = head
        while current:
            length += 1
            current = current.next
        if length < 2:
            return True
        index = 0
        middle = int(length/2)
        current = head
        while current:
            index += 1
            if index == middle:
                second_half = current.next if length % 2 == 0 else current.next.next
                current.next = None
                break
            current = current.next
        second_half = self.reverse(second_half)
        current = head
        pointer1, pointer2 = head, second_half
        while pointer1:
            if pointer1.val != pointer2.val:
                return False
            pointer1, pointer2 = pointer1.next, pointer2.next
        return True
