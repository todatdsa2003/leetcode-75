/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        getHeight(root);
        return max;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int current = leftHeight + rightHeight;
        max = Math.max(max, current);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}