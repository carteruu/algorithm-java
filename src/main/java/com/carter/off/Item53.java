package com.carter.off;

public class Item53 {
    public int search(int[] nums, int target) {
        return 0;
    }

    public int search1(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return 0;
        }
        int p = (end + start) / 2;
        int left = 0;
        int right = 0;
        if (target <= nums[p]) {
            left = search(nums, target, start, p - 1);
        }
        if (target >= nums[p]) {
            right = search(nums, target, p + 1, end);
        }
        return left + right + (nums[p] == target ? 1 : 0);
    }
}
