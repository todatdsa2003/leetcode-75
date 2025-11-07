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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        boolean evenLevel = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int prev = evenLevel ? 0 : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollFirst();
                int v = node.val;

                if (evenLevel) {
                    if ((v & 1) == 0 || v <= prev)
                        return false;
                } else {
                    if ((v & 1) == 1 || v >= prev)
                        return false;
                }
                prev = v;

                if (node.left != null)
                    q.addLast(node.left);
                if (node.right != null)
                    q.addLast(node.right);
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}