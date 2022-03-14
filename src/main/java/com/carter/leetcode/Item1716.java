package com.carter.leetcode;

public class Item1716 {
    //TODO 不对
    public int totalMoney(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i % 7 + n / 7;
        }
        return ans;
    }
}
