class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int p = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    p += 4;
                    if (r > 0 && grid[r - 1][c] == 1)
                        p--;
                    if (r < rows - 1 && grid[r + 1][c] == 1)
                        p--;

                    if (c > 0 && grid[r][c - 1] == 1)
                        p--;
                    if (c < cols - 1 && grid[r][c + 1] == 1)
                        p--;
                }

            }
        }

        return p;
    }
}
