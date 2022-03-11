package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int j = 0; j < nums.length; j++) {
            Integer i = cache.put(nums[j], j);
            if (i != null && j - i <= k) {
                return true;
            }
        }
        return false;
    }
}
