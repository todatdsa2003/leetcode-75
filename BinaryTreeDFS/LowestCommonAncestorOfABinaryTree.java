/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode result1 = lowestCommonAncestor(root.left, p, q);
        TreeNode result2 = lowestCommonAncestor(root.right, p, q);

        if (result1 != null && result2 != null) {
            return root;
        }

        return (result1 != null) ? result1 : result2;
    }
}