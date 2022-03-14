package com.carter.leetcode;

public class Item930 {
    public int numSubarraysWithSum(int[] nums, int k) {
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int sum1 = 0;
        int sum2 = 0;
        int rs = 0;
        while (right < nums.length) {
            sum1 += nums[right];
            while (left1 < right && sum1 > k) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 < right && sum2 >= k) {
                sum2 -= nums[left2];
                left2++;
            }
            rs += left2 - left1;
            right++;
        }
        return rs;
    }

    public int numSubarraysWithSum3(int[] nums, int k) {
        //使用滑动窗口来完成
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        int i = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            k -= nums[j];
            while (k < 0) {
                k += nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int sum = 0;
        int rs = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                rs += prefix[sum - goal];
            }
            prefix[sum]++;
        }
        return rs;
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        int rs = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length && sum <= goal; end++) {
                sum += nums[end];
                if (sum == goal) {
                    rs++;
                }
            }
        }
        return rs;
    }
}
