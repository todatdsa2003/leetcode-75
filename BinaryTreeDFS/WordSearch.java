class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (word.length() > m * n) {
            return false;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int k) {
        if (k == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length ||
                c < 0 || c >= board[0].length ||
                board[r][c] != word.charAt(k)) {

            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, word, r + 1, c, k + 1) ||
                dfs(board, word, r - 1, c, k + 1) ||
                dfs(board, word, r, c + 1, k + 1) ||
                dfs(board, word, r, c - 1, k + 1);

        board[r][c] = temp;

        return found;
    }
}