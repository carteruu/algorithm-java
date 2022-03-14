package com.carter.leetcode;

import java.util.Arrays;

public class Item1512 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numIdenticalPairs2(int[] nums) {
        int count = 0;
        int[] times = new int[101];
        for (int num : nums) {
            count += times[num];
            times[num]++;
        }
        return count;
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Item1512().sort(new int[]{4, 6, 7, 4, 6, 3, 5, 3, 56, 43, 8});
    }
}
