package com.carter.leet;

import java.util.Arrays;

public class Item1877 {
    public int minPairSum(int[] nums) {
        int r = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        int[] arr = new int[100001];
        for (int num : nums) {
            if (num > r) {
                r = num;
            }
            if (num < l) {
                l = num;
            }
            arr[num]++;
        }

        int rs = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            while (arr[l] == 0) {
                l++;
            }
            while (arr[r] == 0) {
                r--;
            }
            rs = Math.max(rs, l + r);
            arr[l]--;
            arr[r]--;
        }
        return rs;
    }

    public int minPairSum1(int[] nums) {
        Arrays.sort(nums);
        int rs = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            rs = Math.max(rs, nums[i] + nums[nums.length - 1 - i]);
        }
        return rs;
    }
}
