/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode head;
    private TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {
        head = null;
        tail = null;
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        node.left = null;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.right = node;
            tail = node;
        }

        inorder(node.right);
    }
}