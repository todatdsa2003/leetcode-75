/**
 * Định nghĩa cho một Binary Tree Node.
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

    /**
     * Hàm chính, nhận vào gốc của cây và tổng mục tiêu.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (targetSum == root.val);
        }
        int newTargetSum = targetSum - root.val;
        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
    }
}