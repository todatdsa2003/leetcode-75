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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // truong hop cay rong
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // bat dau tu goc

        // BFS
        while (!queue.isEmpty()) {
            int n = queue.size(); // so node o tang hien tai
            List<Integer> level = new ArrayList<>(); // luu cac node o tang hien tai

            // duyet qua tat ca node o tang hien tai
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll(); // lay node dau tien trong queue
                level.add(current.val); // them gia tri cua node vao danh sach tang

                if (current.left != null) { // neu co con trai, them vao queue
                    queue.offer(current.left);
                }
                if (current.right != null) { // neu co con phai, them vao queue
                    queue.offer(current.right);
                }
            }

            result.add(level); // hoan thanh 1 tang, them vao list ket qua
        }

        return result;
    }
}