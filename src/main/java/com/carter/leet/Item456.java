package com.carter.leet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Item456 {
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            Deque<Integer> candidateK = new LinkedList<>();
            candidateK.push(nums[n - 1]);
            int maxK = Integer.MIN_VALUE;

            for (int i = n - 2; i >= 0; --i) {
                if (nums[i] < maxK) {
                    return true;
                }
                while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                    maxK = candidateK.pop();
                }
                if (nums[i] > maxK) {
                    candidateK.push(nums[i]);
                }
            }

            return false;
        }
    }

    class Solution1 {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }

            // 左侧最小值
            int leftMin = nums[0];
            // 右侧所有元素
            TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

            for (int k = 2; k < n; ++k) {
                rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
            }

            for (int j = 1; j < n - 1; ++j) {
                if (leftMin < nums[j]) {
                    Integer next = rightAll.ceilingKey(leftMin + 1);
                    if (next != null && next < nums[j]) {
                        return true;
                    }
                }
                leftMin = Math.min(leftMin, nums[j]);
                rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
                if (rightAll.get(nums[j + 1]) == 0) {
                    rightAll.remove(nums[j + 1]);
                }
            }

            return false;
        }
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 2; i < nums.length; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            Map.Entry<Integer, Integer> r = rightMap.higherEntry(leftMin);
            if (r != null && r.getValue() > 0 && r.getKey() < nums[i]) {
                return true;
            }
            leftMin = Math.min(leftMin, nums[i]);
            rightMap.put(nums[i + 1], rightMap.get(nums[i + 1]) - 1);
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[j] > nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
