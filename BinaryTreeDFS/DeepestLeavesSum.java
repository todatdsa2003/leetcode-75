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
    private int max = -1; 
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0); 
        return sum;
    }
    
    private void dfs(TreeNode node, int d) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {           
            if (d > max) {
                max = d;
                sum = node.val;
                
            } else if (d == max) {
                sum += node.val;
            }
            
        } else {
            dfs(node.left, d + 1);
            dfs(node.right, d + 1);
        }
    }
}