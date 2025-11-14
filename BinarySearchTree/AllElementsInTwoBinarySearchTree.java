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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        inorder(root1, a);
        inorder(root2, b);
        return mergeSortedLists(a, b);
    }

    private void inorder(TreeNode node, List<Integer> out) {
        if (node == null)
            return;
        inorder(node.left, out);
        out.add(node.val);
        inorder(node.right, out);
    }

    private List<Integer> mergeSortedLists(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }
        while (i < a.size())
            res.add(a.get(i++));
        while (j < b.size())
            res.add(b.get(j++));
        return res;
    }
}