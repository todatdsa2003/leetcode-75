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
    // BFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);

        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            n1.val = n1.val + n2.val;
            if (n1.left != null && n2.left != null) {
                q1.offer(n1.left);
                q2.offer(n2.left);
            }

            else if (n1.left == null && n2.left != null) {
                n1.left = n2.left;
            }
            if (n1.right != null && n2.right != null) {
                q1.offer(n1.right);
                q2.offer(n2.right);
            } else if (n1.right == null && n2.right != null) {
                n1.right = n2.right;
            }
        }

        return root1;
    }

    // DFS
    // public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    // if (root1 == null && root2 == null) {
    // return null;
    // }
    // if (root1 == null && root2 != null) {
    // return root2;
    // }
    // if (root1 != null && root2 == null) {
    // return root1;
    // }
    // TreeNode root = new TreeNode();
    // root.val = root1.val + root2.val;
    // root.left = mergeTrees(root1.left, root2.left);
    // root.right = mergeTrees(root1.right, root2.right);
    // return root;
    // }

}