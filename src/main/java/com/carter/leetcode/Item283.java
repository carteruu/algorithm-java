package com.carter.leetcode;

public class Item283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes1(int[] nums) {
        int s = 0;
        int zeroNum = 0;
        while (s < nums.length) {
            if (nums[s] != 0) {
                s++;
            }
            int f = s;
            while (f < nums.length && nums[f] == 0) {
                zeroNum++;
                f++;
            }
            while (f < nums.length && nums[f] != 0) {
                nums[s] = nums[f];
                s++;
                f++;
            }
            s = f;
        }
        for (int i = 0; i < zeroNum; i++) {
            nums[nums.length - 1 - (zeroNum - i - 1)] = 0;
        }
    }
}
