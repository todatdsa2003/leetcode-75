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
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        int pathLeft = 0;
        int pathRight = 0;

        if (node.left != null && node.left.val == node.val) {
            pathLeft = 1 + leftLength;
        }

        if (node.right != null && node.right.val == node.val) {
            pathRight = 1 + rightLength;
        }

        this.maxLength = Math.max(this.maxLength, pathLeft + pathRight);
        return Math.max(pathLeft, pathRight);
    }
}