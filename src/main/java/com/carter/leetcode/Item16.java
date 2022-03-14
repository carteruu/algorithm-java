package com.carter.leetcode;

import java.util.Arrays;

public class Item16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                //和上一个元素相同,跳过
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (sum - target < diff) {
                        res = sum;
                        diff = sum - target;
                    }
                    k--;
                    while (k >= 0 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < target) {
                    if (target - sum < diff) {
                        res = sum;
                        diff = target - sum;
                    }
                    j++;
                    while (j < n && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int two = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int three = two + nums[k];
                    if (Math.abs(three - target) < diff) {
                        res = three;
                        diff = Math.abs(res - target);
                    }
                }
            }
        }
        return res;
    }
}
