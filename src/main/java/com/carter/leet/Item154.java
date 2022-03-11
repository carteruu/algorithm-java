package com.carter.leet;

/**
 * 按题意，将数组从中间分成两边，能确定至少有一边是有序的。
 * 有序的一边，最左边的值为最小值。另一边,递归
 * 见注释
 */
public class Item154 {
    public int findMin(int[] nums) {
        return min(nums, 0, nums.length - 1);
    }

    private int min(int[] nums, int low, int high) {
        if (high - low <= 0 || nums[low] < nums[high]) {
            return nums[low];
        }
        int mid = (high + low) >> 1;
        return Math.min(min(nums, low, mid), min(nums, mid + 1, high));
    }
}
