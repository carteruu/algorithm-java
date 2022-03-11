package com.carter.leet;

public class Item2162 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        //只有两种按法:分钟数和秒数;分钟数-1和秒数+60
        int min = targetSeconds / 60;
        int second = targetSeconds % 60;
        int ans = Integer.MAX_VALUE;
        if (min <= 99) {
            //分钟数<=99时,才能用第一种按法
            ans = getAns(startAt, moveCost, pushCost, min, second);
        }
        if (min > 0 && second <= 39) {
            //分钟数大于0,且秒数<=39时,才能用第二种按法
            min -= 1;
            second += 60;
            ans = Math.min(ans, getAns(startAt, moveCost, pushCost, min, second));
        }
        return ans;
    }

    private int getAns(int startAt, int moveCost, int pushCost, int min, int second) {
        int minTen = min / 10;
        int minUnit = min % 10;
        int secondTen = second / 10;
        int secondUnit = second % 10;
        int ans = 0;
        //分数十位,自动补足前缀0,为0时不需要按
        if (minTen > 0) {
            if (startAt != minTen) {
                ans += moveCost;
                startAt = minTen;
            }
            ans += pushCost;
        }
        if (min > 0) {
            //分数个位
            if (minUnit != startAt) {
                ans += moveCost;
                startAt = minUnit;
            }
            ans += pushCost;
        }
        //秒十位
        if (min > 0 || secondTen > 0) {
            if (secondTen != startAt) {
                ans += moveCost;
                startAt = secondTen;
            }
            ans += pushCost;
        }
        //秒个位
        if (min > 0 || second > 0) {
            if (secondUnit != startAt) {
                ans += moveCost;
            }
            ans += pushCost;
        }
        return ans;
    }

    public int minCostSetTime2(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ans = minCostSetTime(((targetSeconds - 40) / 60 * 100 + (targetSeconds - 40) % 60 + 40 + ""), startAt, moveCost, pushCost);
        if (targetSeconds < 6000) {
            ans = Math.min(ans, minCostSetTime((targetSeconds / 60 * 100 + targetSeconds % 60 + ""), startAt, moveCost, pushCost));
        }
        return ans;
    }

    private int minCostSetTime(String s, int startAt, int moveCost, int pushCost) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != (i > 0 ? s.charAt(i - 1) - '0' : startAt)) {
                sum += moveCost;
            }
            sum += pushCost;
        }
        return sum;
    }
}
