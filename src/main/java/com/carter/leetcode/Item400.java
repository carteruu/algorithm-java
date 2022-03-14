package com.carter.leetcode;

public class Item400 {
    public int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }

    public int findNthDigit(int n) {
        int i = 9;
        int sign = 1;
        while (n > (long) sign * i) {
            n -= sign * i;
            i *= 10;
            sign++;
        }
        n -= 1;
        int start = i / 9;
        int num = start + n / sign;
        return (num / (int) Math.pow(10, sign - (n % sign) - 1)) % 10;
    }
}
