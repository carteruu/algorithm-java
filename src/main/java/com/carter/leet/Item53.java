package com.carter.leet;

public class Item53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int preMax = max;
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(max, preMax);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            max = Math.max(max, nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int[][] arr = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            arr[i][i] = nums[i];
            max = Math.max(max, nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                arr[i][j] = arr[i][j - 1] + nums[j];
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }
}
