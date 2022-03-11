package com.carter.leet;

public class Item1219 {
    private final int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        int save = grid[row][col];
        grid[row][col] = 0;
        int max = 0;
        for (int[] step : steps) {
            max = Math.max(max, dfs(grid, row + step[0], col + step[1]));
        }
        grid[row][col] = save;
        return max + save;
    }

    class Solution {
        private final int[] xs = new int[]{1, -1, 0, 0};
        private final int[] ys = new int[]{0, 0, 1, -1};


        public int getMaximumGold(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    //当有黄金的相邻单元格数量小于等于2时,才需要作为起点
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int adjX = i + xs[i];
                        int adjY = j + ys[i];
                        if (adjX >= 0 && adjX < m && adjY >= 0 && adjY < n && grid[adjX][adjY] > 0) {
                            cnt++;
                        }
                    }
                    if (cnt <= 2) {
                        ans = Math.max(ans, dfs(grid, i, j));
                    }
                }
            }
            return ans;
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                return 0;
            }
            int save = grid[row][col];
            grid[row][col] = 0;
            int max = 0;
            for (int i = 0; i < 4; i++) {
                max = Math.max(max, dfs(grid, row + xs[i], col + ys[i]));
            }
            grid[row][col] = save;
            return max + save;
        }
    }
}

