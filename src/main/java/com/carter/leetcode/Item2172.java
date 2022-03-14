package com.carter.leetcode;

public class Item2172 {
    public int maximumANDSum(int[] nums, int numSlots) {
        int ans = 0;
        int[] dp = new int[1 << (numSlots * 2)];
        for (int i = 0; i < dp.length; i++) {
            //nums的下标，表示当前处理下标为idx的数
            int idx = Integer.bitCount(i);
            if (idx >= nums.length) {
                continue;
            }
            //遍历每一个篮子，对空篮子进行处理（所在的位为0）
            for (int j = 0; j < numSlots * 2; ++j) {
                if ((i & (1 << j)) == 0) {
                    int s = i | (1 << j);
                    dp[s] = Math.max(dp[s], dp[i] + ((j / 2 + 1) & nums[idx]));
                    ans = Math.max(ans, dp[s]);
                }
            }
        }
        return ans;
    }

    public int maximumANDSum1(int[] nums, int numSlots) {
        return dfs(nums, 0, new int[numSlots], 0);
    }

    private int dfs(int[] nums, int idx, int[] slotsState, long path) {
        if (idx == nums.length) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < slotsState.length; i++) {
            if (slotsState[i] == 2) {
                continue;
            }
            slotsState[i]++;
            ans = Math.max(ans, dfs(nums, idx + 1, slotsState, path + nums[idx] * (long) Math.pow(10, i)) + (nums[idx] & (i + 1)));
            slotsState[i]--;
        }
        return ans;
    }
}
