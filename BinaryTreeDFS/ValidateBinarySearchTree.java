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
    /*Approach 1: Using Recursive*/
    // public boolean isValidBST(TreeNode root) {
    //     return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // private boolean validate(TreeNode node, long min, long max) {
    //     if (node == null) {
    //         return true;
    //     }

    //     if (node.val <= min || node.val >= max) {
    //         return false;
    //     }

    //     return validate(node.left, min, node.val) && validate(node.right, node.val, max); 
    // }

    /*Approach 2: Using Iterative (Inorder Traversal)*/
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        long prevValue = Long.MIN_VALUE;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();

            if (current.val <= prevValue) {
                return false;
            }
            prevValue = current.val;
            current = current.right;
        }

        return true;
    }
}