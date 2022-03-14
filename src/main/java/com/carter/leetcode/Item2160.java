package com.carter.leetcode;

import java.util.Arrays;

public class Item2160 {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        arr[0] = num / 1000;
        arr[1] = num / 100 % 10;
        arr[2] = num / 10 % 10;
        arr[3] = num % 10;
        Arrays.sort(arr);
        return arr[0] * 10 + arr[2] + arr[1] * 10 + arr[3];
    }
}
