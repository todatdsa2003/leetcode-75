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
    // private ListNode findMiddle(ListNode head) {
    //     ListNode step = head;
    //     ListNode doubleStep = head;

    //     while (doubleStep != null && doubleStep.next != null) {
    //         step = step.next;
    //         doubleStep = doubleStep.next.next;
    //     }

    //     return step;
    // }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode step = head;
        ListNode doubleStep = head;
        ListNode prev = null;

        while (doubleStep != null && doubleStep.next != null) {
            prev = step;
            step = step.next;
            doubleStep = doubleStep.next.next;
        }
        prev.next = step.next;

        // ListNode current = head;
        // while (current.next != middleNode) {
        //     current = current.next;
        // }

        // current.next = middleNode.next;

        return head;
    }
}