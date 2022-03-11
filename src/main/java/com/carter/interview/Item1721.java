package com.carter.interview;

public class Item1721 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        int res = 0;
        while (left <= right) {
            if (leftMax > rightMax) {
                if (rightMax > height[right]) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            } else {
                if (leftMax > height[left]) {
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            }
        }
        return res;
    }
}
