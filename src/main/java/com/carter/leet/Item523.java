package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
            if (sum < k) {
                break;
            }
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);
        int sum = nums[0] % k;
        map.putIfAbsent(sum, 0);
        for (int i = 1; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            Integer left = map.get(sum);
            if (left != null && i - left > 1) {
                return true;
            }
            map.putIfAbsent(sum, i);
        }
        return false;
    }
}
