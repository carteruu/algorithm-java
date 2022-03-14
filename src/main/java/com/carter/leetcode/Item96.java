package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item96 {
    Map<Integer, Long> map = new HashMap<>();

    {
        map.put(0, 1L);
        map.put(1, 1L);
    }

    public int numTrees(int n) {
        if (map.containsKey(n)) {
            return map.get(n).intValue();
        }
        long rs = 0;
        for (int i = 1; i <= n; i++) {
            rs += ((long) numTrees(i - 1) * numTrees(n - i));
        }
        map.put(n, rs);
        return (int) rs;
    }
}
