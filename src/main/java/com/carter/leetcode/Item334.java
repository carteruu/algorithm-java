package com.carter.leetcode;

public class Item334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mid) {
                return true;
            } else if (num > small) {
                mid = num;
            } else {
                small = num;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int[] stack = new int[2];
        int len = 0;
        for (int num : nums) {
            if (len == 0) {
                stack[len] = num;
                len = 1;
                continue;
            }
            if (stack[0] >= num) {
                stack[0] = num;
            } else {
                if (len == 1) {
                    stack[1] = num;
                    len = 2;
                } else {
                    if (stack[1] >= num) {
                        stack[1] = num;
                        len = 2;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
