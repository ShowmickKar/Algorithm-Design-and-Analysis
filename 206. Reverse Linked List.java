/* https://leetcode.com/problems/reverse-linked-list/  */

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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null, after = null;
        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }
}
