package com.carter.leetcode;

public class Item309 {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        while (n > 1) {
            //从左边开始移除或从右边开始移除,数列总数为奇数时,队头的元素会被删除,变为head+step
            if (left || n % 2 == 1) {
                head += step;
            }
            //步长 * 2
            step *= 2;
            //方向
            left = !left;
            //总数 / 2
            n /= 2;
        }
        //返回队头元素
        return head;
    }

    public int lastRemaining2(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) {
                // 正向
                a1 = a1 + step;
            } else {
                // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            //元素个数/2
            cnt = cnt >> 1;
            //步长*2
            step = step << 1;
        }
        return a1;
    }

    public int lastRemaining1(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
