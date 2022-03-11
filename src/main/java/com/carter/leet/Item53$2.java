package com.carter.leet;

public class Item53$2 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
