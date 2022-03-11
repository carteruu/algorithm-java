package com.carter.leet;

public class Item300_1 {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //使用二分,找第一个大于或等于(因为题目要求严格递增)当前值的位置,替换为当前值;
            //如果没找到,说明前面所有数都小于当前值,将长度+1,并将当前值放在最后
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) >> 1;
                //要求严格递增,则这里是小于;不要求严格递增,则这里是小于或等于
                if (tails[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (len == r) {
                len++;
            }
            tails[r] = num;
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private Integer[][] cache;
    private final int min = (int) 1e4;

    public int lengthOfLIS1(int[] nums) {
        cache = new Integer[nums.length][2 * min];
        return dfs(nums, 0, -min);
    }

    private int dfs(int[] nums, int idx, int preNum) {
        if (idx == nums.length) {
            return 0;
        }
        if (cache[idx][preNum + min] != null) {
            return cache[idx][preNum + min];
        }
        //不选择
        int rt = dfs(nums, idx + 1, preNum);
        //选择
        if (nums[idx] >= preNum) {
            rt = Math.max(rt, dfs(nums, idx + 1, nums[idx]) + 1);
        }
        cache[idx][preNum + min] = rt;
        return rt;
    }
}
