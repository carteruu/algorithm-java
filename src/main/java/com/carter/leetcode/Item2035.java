package com.carter.leetcode;

import java.util.Arrays;

public class Item2035 {
    private int ans = Integer.MAX_VALUE;

    public int minimumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        helper(nums, sum, 0, 0, 0);
        return ans;
    }

    private void helper(int[] nums, int sum, int cnt, int idx, int sub) {
        if (idx == nums.length) {
            if (cnt == nums.length / 2) {
                ans = Math.min(ans, Math.abs(sum - sub - sub));
            }
            return;
        }
        //不选择
        helper(nums, sum, cnt, idx + 1, sub);
        //选择
        helper(nums, sum, cnt + 1, idx + 1, sub + nums[idx]);
    }
}
