package com.carter.leetcode;

import java.util.List;

public class Item539 {
    public int findMinDifference(List<String> timePoints) {
        int minDay = 24 * 60;
        if (timePoints.size() > minDay) {
            return 0;
        }
        boolean[] mines = new boolean[minDay];
        for (String timePoint : timePoints) {
            //转换为分钟
            int m = ((timePoint.charAt(0) - '0') * 10 + (timePoint.charAt(1) - '0')) * 60 +
                    (timePoint.charAt(3) - '0') * 10 + timePoint.charAt(4) - '0';
            if (mines[m]) {
                //相同时间,间隔为0
                return 0;
            }
            mines[m] = true;
        }
        //最小时间和最大时间,用来计算跨天的时间差,如00:00和23:59相差1分钟
        int min = -1;
        int max = -1;
        int pre = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minDay; i++) {
            if (mines[i]) {
                if (pre == -1) {
                    pre = i;
                } else {
                    ans = Math.min(ans, i - pre);
                    pre = i;
                }
                if (min == -1) {
                    min = i;
                }
                max = i;
            }
        }
        return Math.min(ans, minDay - (max - min));
    }
}
