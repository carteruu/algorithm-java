package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] set = new int[101];
        for (int num : nums1) {
            set[num] |= 0b1;
        }
        for (int num : nums2) {
            set[num] |= 0b10;
        }
        for (int num : nums3) {
            set[num] |= 0b100;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < set.length; i++) {
            if (Integer.bitCount(set[i]) >= 2) {
                ans.add(i);
            }
        }
        return ans;
    }
}
