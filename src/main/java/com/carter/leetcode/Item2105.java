package com.carter.leetcode;

public class Item2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int cnt = 0;
        //初始位置
        int l = 0;
        int r = plants.length - 1;
        //剩余水量
        int a = capacityA;
        int b = capacityB;

        while (l < r) {
            if (a < plants[l]) {
                cnt++;
                a = capacityA;
            }
            if (b < plants[r]) {
                cnt++;
                b = capacityB;
            }
            a -= plants[l];
            b -= plants[r];
            l++;
            r--;
        }
        if (l == r) {
            if (a >= b) {
                if (a < plants[l]) {
                    cnt++;
                }
            } else {
                if (b < plants[l]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
