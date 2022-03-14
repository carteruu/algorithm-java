package com.carter.leetcode;

import java.util.Arrays;

public class Item41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive4(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                res++;
            } else if (nums[i] > res) {
                return res;
            }
        }
        return res;
    }

    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n];
        for (int num : nums) {
            if (num > 0 && num < n + 1) {
                arr[num - 1] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!arr[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int left;
        int right;
        if (nums[0] > 0) {
            left = nums[0];
            right = nums[0];
        } else {
            left = 0;
            right = 0;
        }
        int res = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > 0) {
                if (num <= left) {
                    if (num == 1) {
                        if (left - num > 1) {
                            res = Math.min(res, num + 1);
                        }
                    } else {
                        res = 1;
                    }
                    left = num;
                }
                if (num >= right) {
                    if (num - right == 1) {
                        res = Math.min(res, num + 1);
                    } else {
                        res = Math.min(res, right + 1);
                    }
                    right = num;
                }
            }
        }
        return res;
    }
}
