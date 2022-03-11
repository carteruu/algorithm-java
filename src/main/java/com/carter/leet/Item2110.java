package com.carter.leet;

public class Item2110 {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int l = 0;
        int r = 0;
        while (l < prices.length) {
            do {
                r++;
            } while (r < prices.length && prices[r - 1] == prices[r] + 1);
            ans += (long) (r - l) * (r - l + 1) / 2;
            l = r;
        }
        return ans;
    }
}
