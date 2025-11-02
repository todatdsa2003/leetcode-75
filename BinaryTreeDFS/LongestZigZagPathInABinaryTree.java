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
    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestZigZag(root.left, 1, true);
        longestZigZag(root.right, 1, false);
        return maxLength;
    }

    private void longestZigZag(TreeNode node, int steps, boolean isLeftTurn) {

        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, steps);
        if (isLeftTurn) {
            longestZigZag(node.right, steps + 1, false);
            longestZigZag(node.left, 1, true);

        } else {
            longestZigZag(node.left, steps + 1, true);
            longestZigZag(node.right, 1, false);
        }
    }
}