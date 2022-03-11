package com.carter.off;

public class Item56$1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int g = 1;
        while ((xor & g) == 0) {
            g <<= 1;
        }
        int xor1 = 0, xor2 = 0;
        for (int num : nums) {
            if ((num & g) != 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        return new int[]{xor1, xor2};
    }
}
