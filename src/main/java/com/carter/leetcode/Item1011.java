package com.carter.leetcode;

public class Item1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0];
        int r = 0;
        for (int w : weights) {
            r += w;
            if (w > l) {
                l = w;
            }
        }
        if (weights.length <= days) {
            return l;
        }

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (check(weights, days, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] weights, int days, int ship) {
        int d = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w <= ship) {
                sum += w;
            } else {
                d++;
                sum = w;
            }
        }
        return d <= days;
    }
}
