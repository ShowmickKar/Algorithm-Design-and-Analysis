/* Problem Link: https://leetcode.com/problems/remove-linked-list-elements/ */

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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.next != null && head.val == val) head = head.next;
        if (head == null || head.next == null && head.val == val) return null;
        ListNode slow_pointer = new ListNode();
        slow_pointer.val = -1;
        slow_pointer.next = head;
        ListNode fast_pointer = new ListNode();
        fast_pointer.val = -1;
        fast_pointer.next = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            fast_pointer = fast_pointer.next;
            if (fast_pointer.val == val) {
                while (fast_pointer != null && fast_pointer.val == val) {
                    fast_pointer = fast_pointer.next;
                }
                slow_pointer.next = fast_pointer;
            } 
            slow_pointer = slow_pointer.next;
            if (slow_pointer != fast_pointer) fast_pointer = fast_pointer.next;
        }
        return head;
    }
}
