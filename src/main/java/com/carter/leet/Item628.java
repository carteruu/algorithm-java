package com.carter.leet;

import java.util.Arrays;

public class Item628 {
    public int maximumProduct(int[] nums) {
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max0) {
                max2 = max1;
                max1 = max0;
                max0 = num;
            } else if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min0) {
                min1 = min0;
                min0 = num;
            } else if (num < min1) {
                min1 = num;
            }
        }
        return Math.max(min0 * min1 * max0, max0 * max1 * max2);
    }

    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
