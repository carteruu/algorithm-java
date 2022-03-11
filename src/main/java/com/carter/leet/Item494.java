package com.carter.leet;

import java.util.Arrays;

public class Item494 {
    public int findTargetSumWays(int[] nums, int target) {
        int diff = Arrays.stream(nums).sum() - target;
        if (diff < 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] arr = new int[neg + 1];
        arr[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                arr[j] += arr[j - nums[i]];
            }
        }
        return arr[neg];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[] temp;
        if (sum < target || -sum > target) {
            return 0;
        }
        int len = sum * 2 + 1;
        int[] arr = new int[len];
        arr[sum] = 1;
        for (int num : nums) {
            temp = new int[len];
            for (int j = arr.length - 1 - num; j >= num; j--) {
                int left = j - num;
                temp[left] += arr[j];
                int right = j + num;
                temp[right] += arr[j];
            }
            arr = temp;
        }
        return arr[target + sum];
    }

    public int findTargetSumWays1(int[] nums, int target) {
        findTargetSumWays(nums, target, 0);
        return result;
    }

    int result = 0;

    private void findTargetSumWays(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }
        findTargetSumWays(nums, target - nums[idx], idx + 1);
        findTargetSumWays(nums, target + nums[idx], idx + 1);
    }
}
