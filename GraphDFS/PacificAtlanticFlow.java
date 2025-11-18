class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
        }

        for (int c = 0; c < cols; c++) {
            dfs(rows - 1, c, atlantic, heights);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, cols - 1, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nextRow = r + d[0];
            int nextCol = c + d[1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) continue;
            if (visited[nextRow][nextCol]) continue;

            if (heights[nextRow][nextCol] >= heights[r][c]) {
                dfs(nextRow, nextCol, visited, heights);
            }
        }
    }
}
