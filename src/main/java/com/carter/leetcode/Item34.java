package com.carter.leetcode;

public class Item34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 相等的下标-最左
     *
     * @param arr
     * @param target
     * @return
     */
    public int findLeft(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == target ? left : -1;
    }

    /**
     * 相等的下标-最右
     *
     * @param arr
     * @param target
     * @return
     */
    public int findRight(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = ((right - left + 1) >> 1) + left;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }
}
