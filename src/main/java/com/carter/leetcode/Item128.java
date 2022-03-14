package com.carter.leetcode;

import java.util.*;

public class Item128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> maxLenMap = new HashMap<>(nums.length);
        int ans = 0;
        for (int num : nums) {
            if (maxLenMap.containsKey(num)) {
                continue;
            }
            int leftLen = maxLenMap.getOrDefault(num - 1, 0);
            int rightLen = maxLenMap.getOrDefault(num + 1, 0);
            int len = leftLen + rightLen + 1;
            ans = Math.max(ans, len);

            maxLenMap.put(num, len);
            maxLenMap.put(num - leftLen, len);
            maxLenMap.put(num + rightLen, len);
        }
        return ans;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1;
            int next = num + 1;
            while (set.contains(next)) {
                len++;
                next++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) {
                continue;
            } else if (diff == 1) {
                len++;
            } else {
                ans = Math.max(ans, len);
                len = 1;
            }
        }
        ans = Math.max(ans, len);
        return ans;
    }
}
