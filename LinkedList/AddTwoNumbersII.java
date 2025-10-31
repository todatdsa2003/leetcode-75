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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int freq = 0;
        ListNode result = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || freq != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + freq;
            int digit = sum % 10;
            freq = sum / 10;

            ListNode newNode = new ListNode(digit);
            newNode.next = result;
            result = newNode;
        }
        return result;
    }
}