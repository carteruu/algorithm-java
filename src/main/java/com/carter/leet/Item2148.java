package com.carter.leet;

import java.util.Arrays;

public class Item2148 {
    public int countElements(int[] nums) {
        int min = nums[0];
        int minCnt = 1;
        int max = nums[0];
        int maxCnt = 1;
        for (int num : nums) {
            if (num < min) {
                min = num;
                minCnt = 1;
            } else if (num == min) {
                minCnt++;
            }

            if (num > max) {
                max = num;
                maxCnt = 1;
            } else if (num == max) {
                maxCnt++;
            }
        }
        if (min == max) {
            return 0;
        }
        return nums.length - minCnt - maxCnt;
    }

    public int countElements1(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //大于最小值,且小于最大值
            if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1]) {
                ans++;
            }
        }
        return ans;
    }
}
