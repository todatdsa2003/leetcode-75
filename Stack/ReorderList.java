import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Deque<ListNode> stack = new ArrayDeque<>();
            ListNode current = slow;
            while (current != null) {
                stack.push(current);
                current = current.next;
            }

            current = head;
            while (!stack.isEmpty()) {
                ListNode lastNode = stack.pop();
                if (current == lastNode || current.next == lastNode) {
                    lastNode.next = null; // Sửa: set null cho lastNode thay vì current
                    break;
                }

                ListNode nextNode = current.next;
                current.next = lastNode;
                lastNode.next = nextNode;
                current = nextNode;
            }
            // Cach tham khao dung two pointer khong dung stack
            // if (head == null || head.next == null) {
            // return;
            // }

            // ListNode slow = head;
            // ListNode fast = head;
            // while (fast != null && fast.next != null) {
            // slow = slow.next;
            // fast = fast.next.next;
            // }

            // ListNode prev = null;
            // ListNode curr = slow;
            // while (curr != null) {
            // ListNode nextTemp = curr.next;
            // curr.next = prev;
            // prev = curr;
            // curr = nextTemp;
            // }

            // ListNode first = head;
            // ListNode second = prev;
            // while (second.next != null) {
            // ListNode temp1 = first.next;
            // ListNode temp2 = second.next;

            // first.next = second;
            // second.next = temp1;

            // first = temp1;
            // second = temp2;
            // }

        }
    }

}
