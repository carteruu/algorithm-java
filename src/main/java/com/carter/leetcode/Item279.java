package com.carter.leetcode;

public class Item279 {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j]);
            }
            arr[i]++;
        }
        return arr[n];
    }

    public int numSquares1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        int len = (int) Math.sqrt(n) + 1;
        for (int i = 1; i < len; i++) {
            arr[i * i] = 1;
        }
        return numSquares(n, arr);
    }

    private int numSquares(int n, int[] arr) {
        if (arr[n] > 0) {
            return arr[n];
        }
        int len = (int) Math.sqrt(n);
        int rs = Integer.MAX_VALUE;
        for (int i = 1; i <= len * len / 2; i++) {
            if (arr[i] > 0) {
                rs = Math.min(rs, numSquares(n - i, arr) + arr[i]);
            }
        }
        arr[n] = rs;
        return rs;
    }
}
