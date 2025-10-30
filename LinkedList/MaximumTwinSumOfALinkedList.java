public class MaximumTwinSumOfALinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int pairSum(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode prev = null;
            ListNode curr = slow;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            int maxSum = 0;
            ListNode firstHalf = head;
            ListNode secondHalf = prev;
            while (secondHalf != null) {
                int currentSum = firstHalf.val + secondHalf.val;
                maxSum = Math.max(maxSum, currentSum);
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return maxSum;
        }
    }
    
}
