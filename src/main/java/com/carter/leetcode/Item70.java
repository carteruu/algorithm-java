package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item70 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
        {
            this.put(1, 1);
            this.put(2, 2);
        }
    };

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 1;
        int step = 2;
        for (int i = 2; i < n; i++) {
            int temp = step;
            step = n1 + step;
            n1 = temp;
        }
        return step;
    }

    public int climbStairs1(int n) {
        Integer step = map.get(n);
        if (step != null) {
            return step;
        }
        step = climbStairs1(n - 1) + climbStairs1(n - 2);
        map.put(n, step);
        return step;
    }
}
