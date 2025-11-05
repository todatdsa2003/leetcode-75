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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
        dfs(node.right);
    }
    //Code tham khao
    // public void recoverTree(TreeNode root) {
    //     TreeNode current = root;
    //     TreeNode first = null;
    //     TreeNode second = null;
    //     TreeNode prev = null; 

    //     while (current != null) {
    //         if (current.left == null) {
    //             if (prev != null && prev.val > current.val) {
    //                 if (first == null) {
    //                     first = prev;
    //                 }
    //                 second = current;
    //             }
    //             prev = current;
    //             current = current.right;
    //         } else {
    //             TreeNode predecessor = current.left;
    //             while (predecessor.right != null && predecessor.right != current) {
    //                 predecessor = predecessor.right;
    //             }

    //             if (predecessor.right == null) {
    //                 predecessor.right = current;
    //                 current = current.left;
    //             } else {
    //                 predecessor.right = null;
    //                 if (prev != null && prev.val > current.val) {
    //                     if (first == null) {
    //                         first = prev;
    //                     }
    //                     second = current;
    //                 }
    //                 prev = current;
    //                 current = current.right;
    //             }
    //         }
    //     }

    //     int temp = first.val;
    //     first.val = second.val;
    //     second.val = temp;
    // }
}