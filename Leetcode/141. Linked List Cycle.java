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


// Approach 2 Using Fast and Slow Pointers

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowPointer = head, fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) return true;
        }
        return false;
    }
}
