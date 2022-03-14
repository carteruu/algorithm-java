package com.carter.leetcode;

public class Item483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(num) / Math.log(2));
        for (int i = 2; i <= mMax; i++) {
            long pow = (long) (Math.log(num) / Math.log(i));
            long r = 0;
            for (int j = 0; j <= pow; j++) {
                r += Math.pow(i, j);
            }
            if (r == num) {
                return String.valueOf(i);
            }
        }
        return String.valueOf(num - 1);
    }

    public String smallestGoodBase1(String n) {
        long num = Long.parseLong(n);
        for (int i = 2; i < num; i++) {
            long temp = num;
            while (temp > 0) {
                temp = (temp - 1) / i;
                if (temp == 1) {
                    return String.valueOf(i);
                }
            }
        }
        return null;
    }
}
