package com.carter.leet;

public class Item268 {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums.length && nums[i] != i) {
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
            if (nums[i] == nums.length) {
                ans = i;
            }
        }
        return ans;
    }
}
