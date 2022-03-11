package com.carter.leet;

import java.util.Arrays;

public class Item2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((grid[i][j] - grid[0][0]) % x != 0) {
                    return -1;
                }
                arr[i * n + j] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        int median = arr[m * n / 2];
        for (int i = 0; i < m * n; i++) {
            ans += Math.abs(arr[i] - median) / x;
        }
        return ans;
    }
}
