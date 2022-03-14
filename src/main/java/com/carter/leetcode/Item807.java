package com.carter.leetcode;

public class Item807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //在左边看的天际线(最高建筑物的高度)
        int[] left = new int[grid.length];
        //在上边看的天际线(最高建筑物的高度)
        int[] top = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                left[i] = Math.max(left[i], grid[i][j]);
                top[j] = Math.max(top[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //增加高度后,每栋建筑物高度必须<=左边和上边的天际线
                ans += Math.min(left[i], top[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
