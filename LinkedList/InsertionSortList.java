/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head;
        ListNode current = head.next;

        while (current != null) {
            if (lastSorted.val <= current.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= current.val) {
                    prev = prev.next;
                }

                lastSorted.next = current.next;
                current.next = prev.next;
                prev.next = current;
            }
            current = lastSorted.next;
        }

        return dummy.next;
    }
}