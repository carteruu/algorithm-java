package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Item689 {
    public int[] maxSumOfThreeSubarrays3(int[] nums, int k) {
        int[] ss = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            ss[0] += nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            ss[i - k + 1] = ss[i - k] - nums[i - k] + nums[i];
        }

        int[] ans = new int[3];
        int maxSum1 = 0, maxSum1Idx = 0;
        int maxSum1And2 = 0, maxSum1And2Idx1 = 0, maxSum1And2Idx2 = 0;
        int maxTotal = 0;
        for (int c = 2 * k; c <= nums.length - k; c++) {
            int a = c - 2 * k;
            if (ss[a] > maxSum1) {
                maxSum1 = ss[a];
                maxSum1Idx = a;
            }
            int b = c - k;
            if (maxSum1 + ss[b] > maxSum1And2) {
                maxSum1And2 = maxSum1 + ss[b];
                maxSum1And2Idx1 = maxSum1Idx;
                maxSum1And2Idx2 = b;
            }
            if (maxSum1And2 + ss[c] > maxTotal) {
                maxTotal = maxSum1And2 + ss[c];
                ans[0] = maxSum1And2Idx1;
                ans[1] = maxSum1And2Idx2;
                ans[2] = c;
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        //保存以当前下标开始的子数组和
        int[] ss = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            ss[0] += nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            ss[i - k + 1] = ss[i - k] - nums[i - k] + nums[i];
        }
        //单调队列,从2*k的下标开始,队头的元素是第三个子数组最大的和
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 2 * k; i <= nums.length - k; i++) {
            while (q.size() > 0 && ss[q.getLast()] < ss[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        int[] ans = new int[3];
        //第一个子数组的最大值及其对应的下标
        int max1 = 0;
        int max1Idx = 0;
        //三个子数组和的最大值
        int max = 0;
        //遍历第二个子数组
        for (int idx2 = k; idx2 <= nums.length - 2 * k; idx2++) {
            //更新第一个子数组最大值
            if (ss[idx2 - k] > max1) {
                max1 = ss[idx2 - k];
                max1Idx = idx2 - k;
            }
            //更新三个子数组和的最大值,有变化时,更新答案
            int sum = max1 + ss[idx2] + ss[q.getFirst()];
            if (sum > max) {
                max = sum;
                ans[0] = max1Idx;
                ans[1] = idx2;
                ans[2] = q.getFirst();
            }
            //第二个子数组向右移动时,更新第三个子数组的队列
            if (ss[idx2 + k] == ss[q.getFirst()]) {
                q.removeFirst();
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int max = 0;
        for (int i = 0; i <= nums.length - 3 * k; i++) {
            int sum1 = preSum[i + k] - preSum[i];
            for (int j = i + k; j <= nums.length - 2 * k; j++) {
                int sum2 = preSum[j + k] - preSum[j];
                for (int l = j + k; l <= nums.length - k; l++) {
                    int sum3 = preSum[l + k] - preSum[l];
                    int sum = sum1 + sum2 + sum3;
                    if (sum > max) {
                        max = sum;
                        ans[0] = i;
                        ans[1] = j;
                        ans[2] = l;
                    }
                }
            }
        }
        return ans;
    }
}
