package com.carter.leetcode;

import java.util.Arrays;

public class Item179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public String largestNumber1(int[] nums) {
        String[] ns = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ns[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ns, (s1, s2) -> {
            if (s1.equals(s2)) {
                return 0;
            }
            return -Long.compare(Long.parseLong(s1 + s2), Long.parseLong(s2 + s1));
        });
        StringBuilder sb = new StringBuilder();
        for (String n : ns) {
            if (sb.length() == 0 && "0".equals(n)) {
                continue;
            }
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
