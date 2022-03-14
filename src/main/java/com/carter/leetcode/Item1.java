package com.carter.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Item1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 3;
        System.out.println(Arrays.toString(new Item1().twoSum(arr, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null && integer != i) {
                return new int[]{i, integer};
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null && integer != i) {
                return new int[]{i, integer};
            }
        }
        throw new IllegalArgumentException("没有正确的答案");
    }
}
