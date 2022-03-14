package com.carter.leetcode;

public class Item410 {
    public int splitArray(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            right += num;
            if (num > left) {
                left = num;
            }
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (helper(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean helper(int[] nums, int m, int mid) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num <= mid) {
                sum += num;
            } else {
                sum = num;
                count++;
            }
        }
        return count <= m;
    }
}
