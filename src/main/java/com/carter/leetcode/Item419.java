package com.carter.leetcode;

public class Item419 {
    private final int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int countBattleships(char[][] board) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, seen, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, boolean[][] seen, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '.' || seen[i][j]) {
            return false;
        }
        seen[i][j] = true;
        for (int[] step : steps) {
            dfs(board, seen, i + step[0], j + step[1]);
        }
        return true;
    }
}
