package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> rs = new ArrayList<>(nums.length);
        int i = 0;
        while (i < nums.length) {
            int start = i;
            i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            StringBuilder sb = new StringBuilder(nums[start] + "");
            if (nums[i - 1] > nums[start]) {
                sb.append("->");
                sb.append(nums[i - 1]);
            }
            rs.add(sb.toString());
        }
        return rs;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> rs = new ArrayList<>();
        if (nums.length == 0) {
            return rs;
        }
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            if (Math.abs(nums[i] - pre) > 1) {
                if (pre == start) {
                    rs.add(start + "");
                } else {
                    rs.add(start + "->" + pre);
                }
                start = nums[i];
            }
        }
        int last = nums[nums.length - 1];
        if (last == start) {
            rs.add(start + "");
        } else {
            rs.add(start + "->" + last);
        }
        return rs;
    }
}
