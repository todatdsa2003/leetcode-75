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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean check = true;

        while (!q.isEmpty()) {
            int n = q.size();
            Integer[] level = new Integer[n];

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll(); 

                int j = check ? i : (n - 1 - i);
                level[j] = node.val; 

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            result.add(Arrays.asList(level));
            check = !check;
        }
        return result;
    }
}