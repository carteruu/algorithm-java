package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dfs(nums, nums.length - 1, 0, new HashMap<>(nums.length)), dfs(nums, nums.length, 1, new HashMap<>(nums.length)));
    }

    private int dfs(int[] nums, int e, int idx, Map<Integer, Integer> map) {
        if (idx >= e) {
            return 0;
        }
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        int max = Math.max(nums[idx] + dfs(nums, e, idx + 2, map), dfs(nums, e, idx + 1, map));
        map.put(idx, max);
        return max;
    }

    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            } else if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }

        public int robRange(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
