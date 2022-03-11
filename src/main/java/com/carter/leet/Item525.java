package com.carter.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Item525 {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        int length = nums.length;
        int[] preSum = new int[length * 2 + 1];
        int sum0 = nums[0] == 1 ? 1 : -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (sum == 0) {
                //0~i满足条件
                maxLen = Math.max(maxLen, i + 1);
                continue;
            }
            if (sum == sum0) {
                //1~i满足条件
                maxLen = Math.max(maxLen, i);
                continue;
            }
            int p = sum + length;
            int idx = preSum[p];
            if (idx > 0) {
                maxLen = Math.max(maxLen, i - idx);
            } else {
                preSum[p] = i;
            }
        }
        return maxLen;
    }

    public int findMaxLength4(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        int length = nums.length;
        int[] preSum = new int[length * 2 + 1];
        Arrays.fill(preSum, -1);
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (sum == 0) {
                //0-i满足条件
                maxLen = Math.max(maxLen, i + 1);
                continue;
            }
            int p = sum + length;
            int idx = preSum[p];
            if (idx >= 0) {
                maxLen = Math.max(maxLen, i - idx);
            } else {
                preSum[p] = i;
            }
        }
        return maxLen;
    }

    public int findMaxLength3(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);
            Integer idx = map.get(sum);
            if (idx != null) {
                maxLen = Math.max(maxLen, i - idx);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public int findMaxLength2(int[] nums) {
        int maxLen = 0;
        //1比0多的数量
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = nums[i] == 1 ? 1 : -1;
            for (int j = i + 1; j < nums.length; j++) {
                diff = diff + (nums[j] == 1 ? 1 : -1);
                if (diff == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public int findMaxLength1(int[] nums) {
        int maxLen = 0;
        //1比0多的数量
        int[][] arr = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i][i] = nums[i] == 1 ? 1 : -1;
            for (int j = i + 1; j < nums.length; j++) {
                arr[i][j] = arr[i][j - 1] + (nums[j] == 1 ? 1 : -1);
                if (arr[i][j] == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
