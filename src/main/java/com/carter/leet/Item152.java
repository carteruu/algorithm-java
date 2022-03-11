package com.carter.leet;

public class Item152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int minPro = nums[0];
        int maxPro = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int mn = num * minPro;
            int mx = num * maxPro;
            minPro = Math.min(Math.min(mn, mx), num);
            maxPro = Math.max(Math.max(mn, mx), num);
            ans = Math.max(ans, maxPro);
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int firstNegative = 1;
        boolean hasNegative = false;
        int ans = Integer.MIN_VALUE;
        int product = 1;
        for (int num : nums) {
            product *= num;
            ans = Math.max(ans, product);
            if (num == 0) {
                product = 1;
                hasNegative = false;
            } else {
                if (product < 0) {
                    if (hasNegative) {
                        ans = Math.max(ans, product / firstNegative);
                    } else {
                        hasNegative = true;
                        firstNegative = product;
                    }
                }
            }
        }
        return ans;
    }

    public int maxProduct1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                ans = Math.max(ans, product);
            }
        }
        return ans;
    }
}
