package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCnt = 0;
        int eqCnt = 0;
        for (int num : nums) {
            if (num < target) {
                lessCnt++;
            } else if (num == target) {
                eqCnt++;
            }
        }
        List<Integer> ans = new ArrayList<>(eqCnt);
        for (int i = lessCnt; i < lessCnt + eqCnt; i++) {
            ans.add(i);
        }
        return ans;
    }

    public List<Integer> targetIndices1(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}
