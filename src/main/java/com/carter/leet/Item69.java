package com.carter.leet;

public class Item69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = x;
        while (left <= right) {
            int mid = (right + left) >> 1;
            long rs = (long) mid * mid;
            if (rs > x) {
                right = mid - 1;
            } else if (rs < x) {
                ans = left;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }
}
