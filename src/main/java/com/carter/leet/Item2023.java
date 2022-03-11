package com.carter.leet;

public class Item2023 {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            String num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                String num2 = nums[j];
                if (target.equals(num1 + num2)) {
                    ans++;
                }
                if (target.equals(num2 + num1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
