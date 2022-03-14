package com.carter.leetcode;

public class item2154 {
    public int findFinalValue(int[] nums, int original) {
        boolean[] e = new boolean[1001];
        for (int num : nums) {
            e[num] = true;
        }
        while (0 < original && original <= 1000 && e[original]) {
            original *= 2;
        }
        return original;
    }
}
