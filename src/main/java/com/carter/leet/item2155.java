package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class item2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = Arrays.stream(nums).sum();
        int max = left + right;
        ans.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left++;
                if (left + right == max) {
                    ans.add(i + 1);
                } else if (left + right > max) {
                    max = left + right;
                    ans.clear();
                    ans.add(i + 1);
                }
            } else {
                right--;
            }
        }
        return ans;
    }
}
