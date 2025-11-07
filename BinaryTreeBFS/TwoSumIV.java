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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int l = 0, r = arr.size() - 1;

        while (l < r) {
            long sum = (long) arr.get(l) + arr.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    private void inorder(TreeNode node, List<Integer> arr) {
        if (node == null)
            return;
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }
}