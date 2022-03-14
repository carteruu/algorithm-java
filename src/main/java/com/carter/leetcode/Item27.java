package com.carter.leetcode;

public class Item27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }
}
