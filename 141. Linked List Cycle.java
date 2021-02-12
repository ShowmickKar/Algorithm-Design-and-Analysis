/* https://leetcode.com/problems/linked-list-cycle/ */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        while (current != null) {
            if (current.val == 50000) return true;
            current.val = 50000;
            current = current.next;
        }
        return false;
    }
}
