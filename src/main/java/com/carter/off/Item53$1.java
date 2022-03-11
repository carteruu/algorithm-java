package com.carter.off;

public class Item53$1 {
    public int search(int[] nums, int target) {
        int right = findBound(nums, target, false);
        if (right == -1) {
            return 0;
        }
        return right - findBound(nums, target, true) + 1;
    }

    public int findBound(int[] arr, int target, boolean lower) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                ans = mid;
            }
            if (arr[mid] > target || (lower && arr[mid] == target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int search1(int[] nums, int target) {
        int rs = 0;
        for (int num : nums) {
            if (num == target) {
                rs++;
            }
        }
        return rs;
    }
}
