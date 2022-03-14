package com.carter.leetcode;

public class Item66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        int c = digits[len - 1] / 10;
        digits[len - 1] %= 10;
        for (int i = len - 2; i >= 0; i--) {
            if (c == 0) {
                break;
            }
            digits[i] = digits[i] + c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }
        if (c == 1) {
            int[] rs = new int[len + 1];
            System.arraycopy(digits, 0, rs, 1, len - 1);
            rs[0] = 1;
            return rs;
        } else {
            return digits;
        }
    }
}
