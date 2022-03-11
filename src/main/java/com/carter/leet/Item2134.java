package com.carter.leet;

import java.util.Arrays;

public class Item2134 {
    public int minSwaps(int[] nums) {
        //1的个数,即窗口范围
        int cnt = Arrays.stream(nums).sum();
        int n = nums.length;
        if (cnt == 0 || cnt == n) {
            return 0;
        }
        //第一个窗口[0,r)中,0的个数
        int r = 0;
        int cnt0 = 0;
        for (; r < cnt; r++) {
            if (nums[r] == 0) {
                cnt0++;
            }
        }
        int ans = cnt0;
        //向右移动窗口,计算0的个数,取最小值
        for (int l = 0; l < n; l++) {
            //左边移出
            if (nums[l] == 0) {
                cnt0--;
            }
            //右边移入
            if (nums[r] == 0) {
                cnt0++;
            }
            //右边界r往右移动,需要取模,避免越界
            r = (r + 1) % n;
            ans = Math.min(ans, cnt0);
        }
        return ans;
    }
}
