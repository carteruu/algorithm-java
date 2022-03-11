package com.carter.leet;

public class Item7 {

    int reverse(int x) {
        int rs = 0;
        while (x != 0) {
            if (rs < Integer.MIN_VALUE / 10 || rs > Integer.MAX_VALUE / 10) {
                return 0;
            }
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return rs;
    }

    int reverse1(int x) {
        int xAbs = Math.abs(x);
        int max = (int) Math.pow(2, 31) - 1;
        int maxSub = max / 10;
        int pre = max;
        while (true) {
            int val = pre / 10;
            if (val <= 0) {
                break;
            }
            pre = val;
        }
        int revert = 0;
        int high = xAbs % 10;
        while (xAbs > 0) {
            if (revert > maxSub && high >= pre) {
                return 0;
            }
            revert = revert * 10 + xAbs % 10;
            xAbs /= 10;
        }
        if (x < 0) {
            return -revert;
        }
        return revert;
    }
}
