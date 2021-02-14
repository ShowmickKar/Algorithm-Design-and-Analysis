/* Problem Link: https://leetcode.com/problems/palindrome-linked-list/submissions/ */

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;        
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int index = 0;
        current = head;
        double temp = length;
        while (current != null) {
            index++;
            if (index == (int)Math.ceil(temp/2) + 1) {
                current = reverse(current);
                break;
            }
            current = current.next;
        }
        ListNode ptr1 = head, ptr2 = current;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val != ptr2.val) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode current = node;
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
