package com.carter.leet;

public class Item1863 {
    int rs = 0;
    int count = 0;

    public int subsetXORSum(int[] nums) {
        subsetXORSum(nums, 0, 0);
        System.out.println(count);
        return rs;
    }

    private void subsetXORSum(int[] nums, int i, int val) {
        count++;
        if (i == nums.length) {
            rs += val;
            return;
        }
        subsetXORSum(nums, i + 1, val);
        subsetXORSum(nums, i + 1, val ^ nums[i]);
    }
}
