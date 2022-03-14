package com.carter.leetcode;

public class Item2091 {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int min = nums[0];
        int minIdx = 0;
        int max = nums[0];
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        //min和max都从左边移除
        int ans = Math.max(minIdx, maxIdx) + 1;
        //min和max都从右边移除
        ans = Math.min(ans, Math.max(nums.length - minIdx, nums.length - maxIdx));
        //min和max分别从两端移除
        if (minIdx < maxIdx) {
            ans = Math.min(ans, minIdx + 1 + nums.length - maxIdx);
        } else {
            ans = Math.min(ans, maxIdx + 1 + nums.length - minIdx);
        }
        return ans;
    }
}
