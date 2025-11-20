class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        image[sr][sc] = newColor;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        image[nr][nc] == oldColor) {

                    image[nr][nc] = newColor;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return image;
    }
    //DFS
    // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //     int oldColor = image[sr][sc];
    //     if (oldColor == newColor) return image;

    //     dfs(image, sr, sc, oldColor, newColor);
    //     return image;
    // }

    // private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
    //     int rows = image.length;
    //     int cols = image[0].length;

    //     if (r < 0 || r >= rows || c < 0 || c >= cols) return; 
    //     if (image[r][c] != oldColor) return;                 
    //     image[r][c] = newColor;

    //     dfs(image, r + 1, c, oldColor, newColor);
    //     dfs(image, r - 1, c, oldColor, newColor); 
    //     dfs(image, r, c + 1, oldColor, newColor); 
    //     dfs(image, r, c - 1, oldColor, newColor);  
    // }
}
