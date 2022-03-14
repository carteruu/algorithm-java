package com.carter.leetcode;

import java.util.Arrays;

public class Item322 {
    int[] map;

    public int coinChange(int[] coins, int amount) {
        map = new int[amount + 1];
        Arrays.fill(map, -2);
        map[0] = 0;
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if (map[amount] >= -1) {
            return map[amount];
        }

        int min = amount + 1;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }
            if (amount == coin) {
                return 1;
            }

            int sub = helper(coins, amount - coin);
            if (sub < 0) {
                continue;
            }
            min = Math.min(min, sub + 1);
        }
        int ans = min > amount ? -1 : min;
        map[amount] = ans;
        return ans;
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                min = Math.min(min, dp[i - coin]);
            }
            dp[i] = min + 1;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                int coin = coins[j - 1];
                dp[i][j] = dp[i][j - 1];
                if (coin > i) {
                    continue;
                }
                if (dp[i - coin][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - coin][j] + 1);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= coins.length; i++) {
            ans = Math.min(ans, dp[amount][i]);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public int coinChange1(int[] coins, int amount) {
        //状态:硬币数-金额
        boolean[][] dp = new boolean[amount + 1][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                for (int k = 0; k < coins.length; k++) {
                    if (j - coins[k] < 0) {
                        continue;
                    }
                    if (dp[i - 1][j - coins[k]]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < amount + 1; i++) {
            if (dp[i][amount]) {
                return i;
            }
        }
        return -1;
    }
}
