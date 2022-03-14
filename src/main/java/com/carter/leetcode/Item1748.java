package com.carter.leetcode;

public class Item1748 {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                ans += i;
            }
        }
        return ans;
    }
}
