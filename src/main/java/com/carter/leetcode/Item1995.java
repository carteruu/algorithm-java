package com.carter.leetcode;

public class Item1995 {
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int[] cnt = new int[301];
        for (int b = nums.length - 3; b >= 1; b--) {
            for (int d = b + 2; d < nums.length; d++) {
                cnt[nums[d] - nums[b + 1] + 100]++;
            }
            for (int a = 0; a < b; a++) {
                ans += cnt[nums[a] + nums[b] + 100];
            }
        }
        return ans;
    }

    public int countQuadruplets1(int[] nums) {
        int ans = 0;
        int[] cnt = new int[301];
        for (int c = nums.length - 2; c >= 2; c--) {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }
}
