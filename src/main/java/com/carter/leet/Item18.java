package com.carter.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //去重
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //去重
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
