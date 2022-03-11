package com.carter.leet;

import java.util.Arrays;

public class Item877 {
    public boolean stoneGame1(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int target = Arrays.stream(piles).sum() / 2;
        for (int i = piles.length - 2; i >= 0; i--) {
            //只有两堆石头时,选择大的
            dp[i][i + 1] = Math.max(piles[i], piles[i + 1]);
            for (int j = i + 2; j < piles.length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j] + piles[i], dp[i][j - 1] + piles[j]);
            }
        }
        return dp[0][piles.length - 1] > target;
    }

    public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, piles.length - 1, Arrays.stream(piles).sum() / 2);
    }

    private boolean stoneGame(int[] piles, int start, int end, int target) {
        if (target < 0) {
            return true;
        }
        if (start >= end) {
            return false;
        }
        return (stoneGame(piles, start + 2, end, target - piles[start]) &&
                stoneGame(piles, start + 1, end - 1, target - piles[start])) ||
                (stoneGame(piles, start + 1, end - 1, target - piles[end]) &&
                        stoneGame(piles, start, end - 2, target - piles[end]));
    }
}
