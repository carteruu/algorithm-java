package com.carter.leet;

public class Item2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }
}