class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] c : connections) {
            int u = c[0], v = c[1];
            adj.get(u).add(v);
            adj.get(v).add(-u);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, adj, visited);
    }

    private int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int nei : adj.get(node)) {
            //Lay gia trị tuyet doi de tim thanh pho that
            int absNext = Math.abs(nei);

            if (!visited[absNext]) {
                if (nei > 0) {
                    changes++;
                }
                changes += dfs(absNext, adj, visited);
            }
        }

        return changes;
    }
}
