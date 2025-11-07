/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> levelList = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                Node currentNode = q.removeFirst();
                levelList.add(currentNode.val);
                if (currentNode.children != null)
                    for (Node c : currentNode.children)
                        q.addLast(c);
            }
            result.add(levelList);
        }
        return result;
    }
}
