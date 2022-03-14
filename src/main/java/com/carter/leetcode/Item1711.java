package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item1711 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int rs = 0;
        int min = deliciousness[0];
        int max = deliciousness[0];
        for (int d : deliciousness) {
            for (int power = 1; power > 0; power <<= 1) {
                int t = power - d;
                if (t < min) {
                    continue;
                }
                if (t > max) {
                    break;
                }
                rs += map.getOrDefault(t, 0);
                rs %= 1_000_000_007;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
            max = Math.max(max, d);
            min = Math.min(min, d);
        }
        return rs;
    }
}
