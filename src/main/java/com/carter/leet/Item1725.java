package com.carter.leet;

public class Item1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int ans = 0;
        for (int[] r : rectangles) {
            int len = Math.min(r[0], r[1]);
            if (len > max) {
                max = len;
                ans = 1;
            } else if (len == max) {
                ans++;
            }
        }
        return ans;
    }
}
