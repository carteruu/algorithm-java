package com.carter.leetcode;

public class Item374 {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess < 0) {
                //结果比猜的数字小,左边
                right = mid - 1;
            }
            if (guess > 0) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return 4 - num;
    }
}
