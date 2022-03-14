package com.carter.offer;

import java.util.HashMap;
import java.util.Map;

public class Off10 {
    public int numWays1(int n) {
        int prepre = 1;
        int pre = 1;
        int rs = 1;
        for (int i = 2; i < n; i++) {
            rs = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = rs;
        }
        return rs;
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
        this.put(0, 1);
        this.put(1, 1);
    }};

    public int numWays(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int step = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        map.put(n, step);
        return step;
    }
}
