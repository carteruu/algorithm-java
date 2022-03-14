package com.carter.leetcode;

public class Item1436 {
    public boolean checkIfExist2(int[] arr) {

        return false;
    }
    public boolean checkIfExist(int[] arr) {
        boolean[] cache = new boolean[2001];
        for (int num : arr) {
            if (num > -500 && num < 500 && cache[num * 2 + 1000]) {
                return true;
            }
            if ((num & 1) == 0 && cache[num / 2 + 1000]) {
                return true;
            }
            cache[num + 1000] = true;
        }
        return false;
    }
}
