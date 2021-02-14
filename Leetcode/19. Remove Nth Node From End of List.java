/* Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        int index = 0;
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        current = dummy;
        while (index < length - n) {
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}
