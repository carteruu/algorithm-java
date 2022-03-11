package com.carter.leet;

public class Item1688 {
    public int numberOfMatches(int n) {
        return n - 1;
    }

    public int numberOfMatches1(int n) {
        int ans = 0;
        while (n > 1) {
            int times = n / 2;
            ans += times;
            n = times + ((n & 1) == 1 ? 1 : 0);
        }
        return ans;
    }
}
