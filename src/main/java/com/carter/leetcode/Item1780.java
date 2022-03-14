package com.carter.leetcode;

public class Item1780 {
    public boolean checkPowersOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return ((n - 1) % 3 == 0 && checkPowersOfThree((n - 1) / 3)) || (n % 3 == 0 && checkPowersOfThree(n / 3));
    }

    public boolean checkPowersOfThree1(int n) {
        int power = (int) (Math.log(n) / Math.log(3)) + 1;
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        for (int i = 0; i < power + 1; i++) {
            int pow = (int) Math.pow(3, i);
            for (int j = n; j >= pow; j--) {
                arr[j] = arr[j - pow];
            }
        }
        return arr[n];
    }
}
