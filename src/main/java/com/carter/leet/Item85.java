package com.carter.leet;

public class Item85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][][] dp = new int[rows][cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 && j == 0) {
                        dp[0][0] = new int[]{1, 1};
                    } else {
                        if (i == 0 || j == 0) {
                            dp[i][j][0] = i == 0 ? dp[i][j - 1][0] + 1 : 1;
                            dp[i][j][1] = i == 0 ? 1 : dp[i - 1][j][1] + 1;
                        } else {
                            dp[i][j][0] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j][0]) + 1;
                            dp[i][j][1] = Math.max(dp[i - 1][j - 1][1], dp[i][j - 1][1]) + 1;
                        }
                    }
                    ans = Math.max(ans, dp[i][j][0] * dp[i][j][1]);
                }
            }
        }
        return ans;
    }
}
