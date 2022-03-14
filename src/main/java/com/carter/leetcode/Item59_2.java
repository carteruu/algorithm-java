package com.carter.leetcode;

public class Item59_2 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] steps = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int stepIdx = 0;
        int i = 0, j = 0;
        for (int num = 1; num <= n * n; num++) {
            ans[i][j] = num;
            int nextI = i + steps[stepIdx][0];
            int nextJ = j + steps[stepIdx][1];
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || ans[nextI][nextJ] != 0) {
                stepIdx = (stepIdx + 1) % 4;
            }
            i = i + steps[stepIdx][0];
            j = j + steps[stepIdx][1];
        }
        return ans;
    }

    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        dfs(ans, 0, n - 1, 0, n - 1, 1);
        return ans;
    }

    private void dfs(int[][] ans, int top, int bottom, int left, int right, int num) {
        if (left > right || top > bottom) {
            return;
        }
        int i = top;
        int j = left;
        //横
        while (j <= right) {
            ans[i][j] = num;
            num++;
            j++;
        }
        //竖
        i = top + 1;
        j = right;
        while (i <= bottom) {
            ans[i][j] = num;
            num++;
            i++;
        }
        //横
        i = bottom;
        j = right - 1;
        while (j >= left) {
            ans[i][j] = num;
            num++;
            j--;
        }
        //竖
        i = bottom - 1;
        j = left;
        while (i > top) {
            ans[i][j] = num;
            num++;
            i--;
        }
        dfs(ans, top + 1, bottom - 1, left + 1, right - 1, num);
    }
}
