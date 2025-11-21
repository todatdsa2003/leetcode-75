class Solution {
    // BFS
    // public boolean possibleBipartition(int n, int[][] dislikes) {
    // List<List<Integer>> g = new ArrayList<>();
    // for (int i = 0; i <= n; i++)
    // g.add(new ArrayList<>());

    // for (int[] d : dislikes) {
    // g.get(d[0]).add(d[1]);
    // g.get(d[1]).add(d[0]);
    // }

    // int[] color = new int[n + 1];

    // for (int i = 1; i <= n; i++) {
    // if (color[i] != 0)
    // continue;

    // Queue<Integer> q = new LinkedList<>();
    // q.add(i);
    // color[i] = 1;

    // while (!q.isEmpty()) {
    // int u = q.poll();
    // for (int v : g.get(u)) {
    // if (color[v] == 0) {
    // color[v] = -color[u];
    // q.add(v);
    // } else if (color[v] == color[u]) {
    // return false;
    // }
    // }
    // }
    // }
    // return true;
    // }

    // DFS
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());

        for (int[] d : dislikes) {
            g.get(d[0]).add(d[1]);
            g.get(d[1]).add(d[0]);
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++)
            if (color[i] == 0 && !dfs(i, 1, color, g))
                return false;

        return true;
    }

    private boolean dfs(int node, int c, int[] color, List<List<Integer>> g) {
        color[node] = c;
        for (int nxt : g.get(node)) {
            if (color[nxt] == 0) {
                // Tham khao cach nay
                if (!dfs(nxt, -c, color, g))
                    return false;
            } else if (color[nxt] == c) {
                return false;
            }
        }
        return true;
    }

}
