class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] vistited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vistited[i]) {
                int[] res = dfs(i, graph, vistited);
                int nodes = res[0], count = res[1] / 2;
                if (count == nodes * (nodes - 1) / 2)
                    ans++;
            }
        }
        return ans;
    }

    private int[] dfs(int u, List<List<Integer>> graph, boolean[] vistited) {
        vistited[u] = true;
        int nodes = 1;
        int sum = graph.get(u).size();

        for (int v : graph.get(u)) {
            if (!vistited[v]) {
                int[] next = dfs(v, graph, vistited);
                nodes += next[0];
                sum += next[1];
            }
        }
        return new int[] { nodes, sum };
    }
}
