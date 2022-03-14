package com.carter.leetcode;

public class Item477 {
    public int totalHammingDistance(int[] nums) {
        int flag;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < 31; i++) {
            flag = 0;
            for (int j = 0; j < len; j++) {
                flag += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }
            count += flag * (len - flag);
        }
        return count;
    }

    public int totalHammingDistance2(int[] nums) {
        int[] flags = new int[31];
        for (int i = 0; i < flags.length; i++) {
            for (int num : nums) {
                flags[i] += num >> i & 1;
            }
        }
        int count = 0;
        for (int flag : flags) {
            count += (flag * (nums.length - flag));
        }
        return count;
    }

    public int totalHammingDistance1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += hammingDistance(nums[i], nums[j]);
            }
        }
        return count;
    }

    protected int hammingDistance(int num1, int num2) {
        int xor = num1 ^ num2;
        int count = 0;
        while (xor != 0) {
            count++;
            xor &= (xor - 1);
        }
        return count;
    }
}
