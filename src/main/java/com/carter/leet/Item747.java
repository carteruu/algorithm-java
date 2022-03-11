package com.carter.leet;

public class Item747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxIdx = 0;
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= max) {
                secondMax = max;
                max = num;
                maxIdx = i;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return max >= secondMax * 2 ? maxIdx : -1;
    }
}
