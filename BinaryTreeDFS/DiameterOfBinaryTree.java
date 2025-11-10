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
    private int max = 0;

    /*Approach 1: Using Recursive */
    // public int diameterOfBinaryTree(TreeNode root) {
    //     max = 0;
    //     getHeight(root);
    //     return max;
    // }

    // private int getHeight(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }

    //     int leftHeight = getHeight(node.left);
    //     int rightHeight = getHeight(node.right);
    //     int current = leftHeight + rightHeight;
    //     max = Math.max(max, current);

    //     return 1 + Math.max(leftHeight, rightHeight);
    // }

    /*Approach 2: Using Iterative (Postorder Traversal) */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Map<TreeNode, Integer> heightMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> postorder = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postorder.push(node);

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        int max = 0;

        while (!postorder.isEmpty()) {
            TreeNode node = postorder.pop();
            int leftHeight = heightMap.getOrDefault(node.left, 0);
            int rightHeight = heightMap.getOrDefault(node.right, 0);

            int currentDiameter = leftHeight + rightHeight;
            max = Math.max(max, currentDiameter);

            heightMap.put(node, 1 + Math.max(leftHeight, rightHeight));
        }

        return max;
    }
}