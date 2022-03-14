package com.carter.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Item2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(o -> Integer.compare(o, pivot)))
                .mapToInt(i -> i).toArray();
    }

    public int[] pivotArray1(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, pivot);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                ans[left] = nums[i];
                left++;
            }
            if (nums[nums.length - 1 - i] > pivot) {
                ans[right] = nums[nums.length - 1 - i];
                right--;
            }
        }
        return ans;
    }
}
