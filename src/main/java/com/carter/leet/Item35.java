package com.carter.leet;

public class Item35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public int t(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (nums[mid] > t) {
                right = mid - 1;
            } else if (nums[mid] < t) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
