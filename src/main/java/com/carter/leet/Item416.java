package com.carter.leet;

public class Item416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        int target = sum / 2;
        if ((sum & 1) == 1 || max > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
