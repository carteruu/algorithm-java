package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item198 {
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prepre = 0;
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = ans;
        }
        return ans;
    }

    private Map<Integer, Integer> map;

    public int rob(int[] nums) {
        map = new HashMap<>(nums.length);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, Integer idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        int ans = Math.max(dfs(nums, idx + 1), dfs(nums, idx + 2) + nums[idx]);
        map.put(idx, ans);
        return ans;
    }
}
