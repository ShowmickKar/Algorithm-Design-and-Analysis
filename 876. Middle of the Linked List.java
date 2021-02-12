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
