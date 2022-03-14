package com.carter.leetcode;

public class Item260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int b = 0;
        while (b < 32) {
            if (((xor >> b) & 1) == 1) {
                break;
            }
            b++;
        }
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums) {
            if (((num >> b) & 1) == 1) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        return new int[]{xor1, xor2};
    }
}
