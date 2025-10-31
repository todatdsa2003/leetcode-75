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
    Map<Long, Integer> prefixSumCounts = new HashMap<>();
    int total = 0;
    long k;

    public int pathSum(TreeNode root, int targetSum) {
        this.k = (long) targetSum;
        prefixSumCounts.put(0L, 1);
        dfs(root, 0L);
        return total;
    }

    private void dfs(TreeNode node, long sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        long complement = sum - k;
        total += prefixSumCounts.getOrDefault(complement, 0);
        prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        dfs(node.left, sum);
        dfs(node.right, sum);
        prefixSumCounts.put(sum, prefixSumCounts.get(sum) - 1);
    }

}