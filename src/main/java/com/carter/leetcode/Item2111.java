package com.carter.leetcode;


import java.util.ArrayList;

public class Item2111 {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        int len = arr.length / k;
        for (int i = 0; i < k; i++) {
            int l = arr.length % k > i ? len + 1 : len;
            if (l == 1) {
                continue;
            }
            ans += l - lengthOfLIS(arr, k, i, l);
        }
        return ans;
    }

    private int lengthOfLIS(int[] arr, int k, int start, int len) {
        int[] tails = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int num = arr[i * k + start];
            int l = 0, r = ans;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (tails[mid] <= num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (r == ans) {
                ans++;
            }
            tails[r] = num;
        }
        return ans;
    }

    class Solution {

        public int kIncreasing(int[] arr, int k) {
            ArrayList<Integer>[] lists = new ArrayList[k];
            for (int i = 0; i < k; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < arr.length; i++) {
                lists[i % k].add(arr[i]);
            }
            int sum = 0;
            for (ArrayList<Integer> list : lists) {
                sum += list.size() - lengthOfLIS(list);
            }
            return sum;
        }

        public int lengthOfLIS(ArrayList<Integer> nums) {
            int[] tails = new int[nums.size()];
            int size = 0;
            for (int x : nums) {
                int i = 0, j = size;
                while (i != j) {
                    int m = (i + j) / 2;
                    if (tails[m] <= x) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                tails[i] = x;
                if (i == size) {
                    ++size;
                }
            }
            return size;
        }
    }
}
