package com.carter.leetcode;

public class Item2167 {
    public int minimumTime(String s) {
        int n = s.length();
        int ans = n;
        int pre = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                pre = Math.min(pre + 2, i + 1);
            }
            ans = Math.min(ans, pre + n - 1 - i);
        }
        return ans;
    }

    public int minimumTime1(String s) {
        int n = s.length();
        int ans = n;
        //从左边开始,计算处理每一节车厢需要的最少时间
        int[] dpLeft = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                //含违禁货物,最少时间为整个左边移除或移除前一节车厢+2
                dpLeft[i + 1] = Math.min(i + 1, dpLeft[i] + 2);
            } else {
                //不含违禁货物,和处理前一节车厢的时间相同
                dpLeft[i + 1] = dpLeft[i];
            }
        }
        //从右边开始,计算处理每一节车厢需要的最少时间
        int timeRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            //同上
            if (s.charAt(i) == '1') {
                timeRight = Math.min(timeRight + 2, n - i);
            }
            //计算结果
            ans = Math.min(ans, dpLeft[i] + timeRight);
        }
        return ans;
    }
}
