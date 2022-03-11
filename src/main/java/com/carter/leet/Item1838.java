package com.carter.leet;

import java.util.*;

public class Item1838 {
    public int maxFrequency(int[] nums, int k) {
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        int frequency = 1, preNum = -1, preCount = 0, increment = 0, left = 0;
        for (int num = 0; num < count.length; num++) {
            if (count[num] == 0) {
                continue;
            }
            if (preNum == -1) {
                preNum = num;
                preCount = count[num];
                frequency = count[num];
                left = num;
            } else {
                increment += (num - preNum) * preCount;
                preCount += count[num];
                preNum = num;
                while (increment > k) {
                    if (count[left] > 0) {
                        increment -= num - left;
                        count[left]--;
                        preCount--;
                    } else {
                        left++;
                    }
                }
                frequency = Math.max(frequency, preCount);
            }
        }
        return frequency;
    }

    public int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        int rs = 0;
        int left = 0;
        long total = 0;
        for (int right = 1; right < nums.length; right++) {
            total += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (total > k) {
                total -= nums[right] - nums[left];
                left++;
            }
            rs = Math.max(rs, right - left + 1);
        }
        return rs;
    }

    public int maxFrequency2(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();

        int maxTime = 0;
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num]++;
            maxTime = Math.max(maxTime, arr[num]);
        }

        for (int i = max; i >= 0; i--) {
            if (arr[i] == 0) {
                continue;
            }
            int tempK = k;
            int times = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == 0) {
                    continue;
                }
                int m = tempK / (i - j);
                if (m > arr[j]) {
                    tempK -= (i - j) * arr[j];
                    times += arr[j];
                    maxTime = Math.max(maxTime, times);
                } else {
                    times += m;
                    maxTime = Math.max(maxTime, times);
                    break;
                }
            }
        }
        return maxTime;
    }
}
