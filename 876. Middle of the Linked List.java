/* Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/ */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Approach 1 - finding the length of the linked list
class Solution {
    public ListNode middleNode(ListNode head) {
        int list_length = 0;
        ListNode current = head;
        while (current != null) {
            list_length++;
            current = current.next;
        }
        int index = 0;
        current = head;
        while (current != null) {
            index++;
            if (index == list_length/2 + 1) {
                return current;
            }
            current = current.next;
        }
        return head;
    }
}

// Approach 2 - Using Fast and Slow Pointers

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null) {
            if (fastPointer.next == null) return slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
