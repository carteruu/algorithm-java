package com.carter.leetcode;

public class Item1227 {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = null;
        for (int i = 0; i < rows; i++) {
            int[] next = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        next[j] = 1;
                    } else {
                        next[j] = Math.min(dp[j - 1], Math.min(dp[j], next[j - 1])) + 1;
                    }
                    ans += next[j];
                }
            }
            dp = next;
        }
        return ans;
    }

    public int countSquares1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}
