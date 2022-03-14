package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Item1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }
        int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int height = 0;
        while (queue.size() > 0) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] step : steps) {
                    int x = poll[0] + step[0];
                    int y = poll[1] + step[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !seen[x][y]) {
                        isWater[x][y] = height;
                        queue.offer(new int[]{x, y});
                        seen[x][y] = true;
                    }
                }
            }
        }
        return isWater;
    }
}
