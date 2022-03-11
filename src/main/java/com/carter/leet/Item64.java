package com.carter.leet;

public class Item64 {
    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            temp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                temp[j] = Math.min(temp[j - 1], dp[j]) + grid[i][j];
            }
            dp = temp;
        }
        return dp[n - 1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 2; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public int minPathSum(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];
        return helper(grid, 0, 0, cache);
    }

    private int helper(int[][] grid, int i, int j, int[][] cache) {
        if (i == grid.length || j == grid[i].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j];
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int ans = grid[i][j] + Math.min(helper(grid, i + 1, j, cache), helper(grid, i, j + 1, cache));
        cache[i][j] = ans;
        return ans;
    }
}
