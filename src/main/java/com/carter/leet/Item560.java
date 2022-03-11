package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int val;
        for (int i = 0; i < nums.length; i++) {
            val = 0;
            for (int j = i; j < nums.length; j++) {
                val += nums[j];
                if (val == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
