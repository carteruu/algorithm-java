package com.carter.leetcode;

public class Item11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * min);
            while (left < right && height[left] <= min) {
                left++;
            }
            while (right > left && height[right] <= min) {
                right--;
            }
        }
        return res;
    }
}
