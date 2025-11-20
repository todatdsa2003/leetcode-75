class Solution {
    public int nearestExit(char[][] maze, int[] ent) {
        int m = maze.length, n = maze[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { ent[0], ent[1] });
        maze[ent[0]][ent[1]] = '+';

        int steps = 0;
        int[][] D = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                int[] cur = q.removeFirst();
                int r = cur[0], c = cur[1];

                if ((r == 0 || c == 0 || r == m - 1 || c == n - 1)
                        && !(r == ent[0] && c == ent[1]))
                    return steps;

                for (int[] d : D) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                        maze[nr][nc] = '+';
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
