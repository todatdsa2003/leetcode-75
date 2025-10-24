class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // Key: List dai dien cho row
        // Value: So lan xuat hien cua row do
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        // Dem lan xuat hien cua tung row va luu vao rowMap
        for (int i = 0; i < n; i++) {
            List<Integer> rowKey = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowKey.add(grid[i][j]);
            }

            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
        }

        // Vong lap qua tung cot dem so cap row-col giong nhau
        for (int j = 0; j < n; j++) {
            List<Integer> colKey = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                colKey.add(grid[i][j]);
            }

            count += rowMap.getOrDefault(colKey, 0);
        }

        return count;
    }
}