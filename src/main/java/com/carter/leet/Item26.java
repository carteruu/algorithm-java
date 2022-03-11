package com.carter.leet;

import java.util.Arrays;

public class Item26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                p += 1;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = nums.length;
        int cur = nums[0];
        int del = 0;
        int i = 1;
        while (i < count) {
            if (nums[i] == cur) {
                //删除
                del++;
            } else {
                cur = nums[i];
                System.arraycopy(nums, i, nums, i - del, count - i);
                count -= del;
                i -= del;
                del = 0;
            }
            i++;
        }
        count -= del;
        return count;
    }
}
