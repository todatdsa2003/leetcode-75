/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node dummy = new Node(0);
        Node copyCurrent = dummy;
        current = head;

        while (current != null) {
            copyCurrent.next = current.next;
            copyCurrent = copyCurrent.next;

            current.next = current.next.next;
            current = current.next;
        }
        System.gc();
        return dummy.next;
    }
}