class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        boolean[] checked = new boolean[n];
        return dfs(source, destination, checked, list);
    }

    private boolean dfs(int node, int destination, boolean[] checked, List<List<Integer>> list) {
        if (node == destination) return true;

        checked[node] = true;

        for (int next : list.get(node)) {
            if (!checked[next]) {
                if (dfs(next, destination, checked, list)) {
                    return true;
                }
            }
        }

        return false;
    }
}
