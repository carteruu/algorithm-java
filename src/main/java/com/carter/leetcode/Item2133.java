package com.carter.leetcode;

public class Item2133 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[] set = new boolean[n];
        for (int i = 0; i < n; i++) {
            //横
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (num < 1 || n < num || set[num - 1]) {
                    return false;
                }
                set[num - 1] = true;
            }
            //竖
            for (int j = 0; j < n; j++) {
                int num = matrix[j][i];
                if (num < 1 || n < num || !set[num - 1]) {
                    return false;
                }
                set[num - 1] = false;
            }
        }
        return true;
    }
}
