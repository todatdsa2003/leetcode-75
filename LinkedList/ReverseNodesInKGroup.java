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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            ListNode prev = reverseKGroup(curr, k);
            for (int i = 0; i < k; i++) {
                ListNode nextTemp = head.next;
                head.next = prev;
                prev = head;
                head = nextTemp;
            }
            head = prev;
        }

        return head;
    }
}