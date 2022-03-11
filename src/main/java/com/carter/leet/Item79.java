package com.carter.leet;

public class Item79 {
    private char[][] board;
    private char[] word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean ans = helper(i, j, 0, visited);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int idx, boolean[][] visited) {
        if (idx == word.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean ans = board[i][j] == word[idx]
                && (helper(i + 1, j, idx + 1, visited)
                || helper(i - 1, j, idx + 1, visited)
                || helper(i, j + 1, idx + 1, visited)
                || helper(i, j - 1, idx + 1, visited));
        visited[i][j] = false;
        return ans;
    }
}
