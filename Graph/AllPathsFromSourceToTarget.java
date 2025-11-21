class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] g, int node, List<Integer> path, List<List<Integer>> res) {
        path.add(node);

        if (node == g.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int next : g[node]) {
                dfs(g, next, path, res);
            }
        }

        path.remove(path.size() - 1);
    }
}
