package com.carter.leet;

public class Item375 {
    private Integer[][] cache;

    public int getMoneyAmount1(int n) {
        cache = new Integer[n + 1][n + 1];
        return helper(1, n);
    }

    private int helper(int l, int h) {
        if (l >= h) {
            return 0;
        }
        if (cache[l][h] != null) {
            return cache[l][h];
        }
        int rs = Integer.MAX_VALUE;
        for (int i = l; i < h; i++) {
            rs = Math.min(rs, i + Math.max(helper(l, i - 1), helper(i + 1, h)));
        }
        cache[l][h] = rs;
        return rs;
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

    class Solution {
        public int getMoneyAmount(int n) {
            int[][] f = new int[n + 1][n + 1];
            for (int i = n - 1; i >= 1; i--) {
                for (int j = i + 1; j <= n; j++) {
                    int minCost = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int cost = k + Math.max(f[i][k - 1], f[k + 1][j]);
                        minCost = Math.min(minCost, cost);
                    }
                    f[i][j] = minCost;
                }
            }
            return f[1][n];
        }
    }
}
