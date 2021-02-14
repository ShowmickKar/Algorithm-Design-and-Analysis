/* Problem Link: https://leetcode.com/problems/add-two-numbers/ */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode current = head;
        
        int carry = 0;
        ListNode ptr1 = l1, ptr2 = l2;
        while(ptr1 != null || ptr2 != null) {
            int node_sum = carry;
            if (ptr1 != null) {
                node_sum += ptr1.val;
                ptr1 = ptr1.next;
            }
           if (ptr2 != null) {
                node_sum += ptr2.val;
                ptr2 = ptr2.next;
            }
            ListNode new_node = new ListNode(node_sum % 10, null);
            current.next = new_node;
            carry = node_sum / 10;
            current = current.next;
        }
        if (carry > 0) {
            ListNode new_node = new ListNode(carry, null);
            current.next = new_node;
        }
        return head.next;
    }
}
