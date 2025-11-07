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
    public int maxLevelSum(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        int level = 1;
        int result = 1;
        long bestSum = Long.MIN_VALUE;

        while (!q.isEmpty()) {
            int n = q.size();
            long sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = q.pollFirst();
                sum += node.val;

                if (node.left != null)
                    q.addLast(node.left);
                if (node.right != null)
                    q.addLast(node.right);
            }

            if (sum > bestSum) {
                bestSum = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}