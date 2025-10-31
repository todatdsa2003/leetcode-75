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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for (int i = 0; i < a - 1; i++) {
            start = start.next;
        }

        ListNode end = start;
        for (int i = 0; i < (b - a + 2); i++) {
            end = end.next;
        }

        ListNode list2_tail = list2;
        while (list2_tail.next != null) {
            list2_tail = list2_tail.next;
        }

        start.next = list2;
        list2_tail.next = end;

        return list1;
    }
}