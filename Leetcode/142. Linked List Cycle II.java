/* Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/ */

// Approach 1 - Using a HashMap, Time Complexity O(n), Space Complexity O(n)

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
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Boolean> nodes = new HashMap<ListNode, Boolean>();
        ListNode current = head;
        while (current != null) {
            if (nodes.get(current) != null) return current;
            nodes.put(current, true);
            current = current.next;
        }
        return null;
    }
}

// Approach 2 - Using Fast and Slow Pointers, Time Complexity O(n), Space Complexity O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }                
                return start;
            }
        }
        return null;
    }
}
