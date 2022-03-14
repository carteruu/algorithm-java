package com.carter.leetcode;

public class Item2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int idx1 = 0;
        int idx2 = 1;
        for (int num : nums) {
            if (num > 0) {
                ans[idx1] = num;
                idx1 += 2;
            } else {
                ans[idx2] = num;
                idx2 += 2;
            }
        }
        return ans;
    }

    public int[] rearrangeArray1(int[] nums) {
        int[] ans = new int[nums.length];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                //正数
                while (nums[idx1] < 0) {
                    idx1++;
                }
                ans[i] = nums[idx1];
                idx1++;
            } else {
                //负数
                while (nums[idx2] > 0) {
                    idx2++;
                }
                ans[i] = nums[idx2];
                idx2++;
            }
        }
        return ans;
    }
}
