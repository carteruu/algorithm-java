package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item198$2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int max = Math.max(a + nums[i], b);
            a = b;
            b = max;
        }
        return b;
    }

    public int rob1(int[] nums) {
        return helper(nums, 0, new HashMap<>());
    }

    private int helper(int[] nums, int idx, Map<Integer, Integer> map) {
        if (idx >= nums.length) {
            return 0;
        }
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        int max = Math.max(nums[idx] + helper(nums, idx + 2, map), helper(nums, idx + 1, map));
        map.put(idx, max);
        return max;
    }
}
