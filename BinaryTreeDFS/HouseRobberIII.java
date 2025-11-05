class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftResult = dfs(node.left);
        int[] rightResult = dfs(node.right);
        int skip = Math.max(leftResult[0], leftResult[1]) + 
                          Math.max(rightResult[0], rightResult[1]);
        int robCurrent = node.val + leftResult[0] + rightResult[0];
        
        return new int[]{skip, robCurrent};
    }
}