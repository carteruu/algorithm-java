package com.carter.leet;

import java.util.Arrays;

public class Item912 {
    public int[] sortArray(int[] nums) {
        int[] arr = new int[100001];
        for (int num : nums) {
            arr[num + 50000]++;
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            while (arr[num] == 0) {
                num++;
            }
            nums[i] = num - 50000;
            arr[num]--;
        }
        return nums;
    }

    public int[] sortArray1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
