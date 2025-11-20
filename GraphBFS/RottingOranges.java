class Solution {
    public int orangesRotting(int[][] g) {
        int m = g.length, n = g[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (g[i][j] == 1)
                    fresh++;

        if (fresh == 0)
            return 0;

        int minutes = -1;
        int[][] D = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            minutes++;
            for (int k = q.size(); k > 0; k--) {
                int[] cur = q.removeFirst();
                int r = cur[0], c = cur[1];

                for (int[] d : D) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && g[nr][nc] == 1) {
                        g[nr][nc] = 2;
                        fresh--;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
