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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        root.val = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            long sum1 = 0;
            List<TreeNode> listNodes = new ArrayList<>(n); 

            for (int i = 0; i < n; i++) {
                TreeNode parent = q.poll();
                listNodes.add(parent);

                if (parent.left  != null) sum1 += parent.left.val;
                if (parent.right != null) sum1 += parent.right.val;
            }
            for (TreeNode parent : listNodes) {
                long siblingSum = 0;
                if (parent.left  != null) siblingSum += parent.left.val;
                if (parent.right != null) siblingSum += parent.right.val;

                if (parent.left != null) {
                    parent.left.val = (int)(sum1 - siblingSum);
                    q.offer(parent.left);
                }
                if (parent.right != null) {
                    parent.right.val = (int)(sum1 - siblingSum);
                    q.offer(parent.right);
                }
            }
        }

        return root;
    }
}
