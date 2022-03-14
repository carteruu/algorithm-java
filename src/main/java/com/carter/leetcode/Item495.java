package com.carter.leetcode;

public class Item495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            ans += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        ans += duration;
        return ans;
    }
}
