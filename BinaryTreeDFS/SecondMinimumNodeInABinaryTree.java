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
    private int min1;
    private long secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);

        if (secondMin == Long.MAX_VALUE) {
            return -1;
        } else {
            return (int) secondMin;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val > min1) {
            secondMin = Math.min(secondMin, node.val);
            return;
        }

        dfs(node.left);
        dfs(node.right);
    }
}