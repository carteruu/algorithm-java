package com.carter.leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class Item2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        //单调栈
        Deque<Integer> leftMaxStack = new ArrayDeque<>(n);
        Deque<Integer> rightMaxStack = new ArrayDeque<>(n);
        Deque<Integer> leftMinStack = new ArrayDeque<>(n);
        Deque<Integer> rightMinStack = new ArrayDeque<>(n);
        int[] leftMaxIdx = new int[n];
        int[] rightMaxIdx = new int[n];
        int[] leftMinIdx = new int[n];
        int[] rightMinIdx = new int[n];
        for (int i = 0; i < n; i++) {
            //左边>当前值的下标,没有则为-1
            while (leftMaxStack.size() > 0 && nums[leftMaxStack.peek()] <= nums[i]) {
                leftMaxStack.pop();
            }
            leftMaxIdx[i] = leftMaxStack.size() > 0 ? leftMaxStack.peek() : -1;
            leftMaxStack.push(i);
            //右边>=当前值的下标,没有则为n
            while (rightMaxStack.size() > 0 && nums[rightMaxStack.peek()] < nums[n - 1 - i]) {
                rightMaxStack.pop();
            }
            rightMaxIdx[n - 1 - i] = rightMaxStack.size() > 0 ? rightMaxStack.peek() : n;
            rightMaxStack.push(n - 1 - i);
            //左边<当前值的下标,没有则为-1
            while (leftMinStack.size() > 0 && nums[leftMinStack.peek()] >= nums[i]) {
                leftMinStack.pop();
            }
            leftMinIdx[i] = leftMinStack.size() > 0 ? leftMinStack.peek() : -1;
            leftMinStack.push(i);
            //右边<=当前值的下标,没有则为n
            while (rightMinStack.size() > 0 && nums[rightMinStack.peek()] > nums[n - 1 - i]) {
                rightMinStack.pop();
            }
            rightMinIdx[n - 1 - i] = rightMinStack.size() > 0 ? rightMinStack.peek() : n;
            rightMinStack.push(n - 1 - i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            //当前值作为最大值和最小值存在的子数组个数(leftLen * rightLen)
            ans += (long) (i - leftMaxIdx[i]) * (rightMaxIdx[i] - i) * nums[i]
                    - (long) (i - leftMinIdx[i]) * (rightMinIdx[i] - i) * nums[i];
        }
        return ans;
    }

    public long subArrayRanges2(int[] nums) {
        int n = nums.length;
        int left, right;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            left = right = i;
            // 找到左右以 nums[i] 为最大值的最远左右点
            while (left - 1 >= 0 && nums[left - 1] < nums[i]) {
                left--;
            }
            while (right + 1 < n && nums[right + 1] <= nums[i]) {
                right++;
            }
            ans += (right - i + 1) * (i - left + 1) * (long) nums[i];

            left = right = i;
            // 找到左右以 nums[i] 为最小值的最远左右点
            while (left - 1 >= 0 && nums[left - 1] > nums[i]) {
                left--;
            }
            while (right + 1 < n && nums[right + 1] >= nums[i]) {
                right++;
            }
            ans -= (right - i + 1) * (i - left + 1) * (long) nums[i];
        }
        return ans;
    }

    public long subArrayRanges1(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (nums[j] < min) {
                    min = nums[j];
                }
                ans += max - min;
            }
        }
        return ans;
    }
}
