package com.carter.leetcode;

public class Item1342 {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                //偶数
                num >>= 1;
            } else {
                num--;
            }
            ans++;
        }
        return ans;
    }
}
