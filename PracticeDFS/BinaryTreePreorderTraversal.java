class Solution {
    /* 1. Using Recusion (recommend) */
    // public List<Integer> preorderTraversal(TreeNode root) {
    // List<Integer> result = new ArrayList<>();
    // preorder(root, result);
    // return result;
    // }

    // private void preorder(TreeNode node, List<Integer> result) {
    // if (node == null)
    // return;

    // result.add(node.val);
    // preorder(node.left, result);
    // preorder(node.right, result);
    // }

    /* 2. Using Stack */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val); // Visit current node

            // Push right before left
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }
}