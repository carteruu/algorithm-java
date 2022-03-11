package com.carter.off;

public class Item53$2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            while (nums[i] != n && nums[i] != i) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            if (nums[i] == n) {
                ans = i;
            }
        }
        return ans;
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] == m) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return i;
        }
    }
}
