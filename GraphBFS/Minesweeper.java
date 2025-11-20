class Solution {
    private static final int[][] DIR = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
            { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };

    public char[][] updateBoard(char[][] b, int[] click) {
        int r = click[0], c = click[1];

        if (b[r][c] == 'M') {
            b[r][c] = 'X';
            return b;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { r, c });

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int cr = cur[0], cc = cur[1];

            if (b[cr][cc] != 'E')
                continue;

            int mines = 0;
            for (int[] d : DIR) {
                int nr = cr + d[0], nc = cc + d[1];
                if (nr >= 0 && nr < b.length && nc >= 0 && nc < b[0].length && b[nr][nc] == 'M')
                    mines++;
            }

            if (mines > 0) {
                b[cr][cc] = (char) (mines + '0');
                continue;
            }

            b[cr][cc] = 'B';
            for (int[] d : DIR) {
                int nr = cr + d[0], nc = cc + d[1];
                if (nr >= 0 && nr < b.length && nc >= 0 && nc < b[0].length && b[nr][nc] == 'E')
                    q.addLast(new int[] { nr, nc });
            }
        }

        return b;
    }
}
