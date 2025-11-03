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
    int matchingNodesCount = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return matchingNodesCount;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftSubtreeData = dfs(node.left);
        int[] rightSubtreeData = dfs(node.right);
        int currentSum = leftSubtreeData[0] + rightSubtreeData[0] + node.val;
        int currentCount = leftSubtreeData[1] + rightSubtreeData[1] + 1;
        int average = currentSum / currentCount; 
        if (average == node.val) {
            matchingNodesCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}