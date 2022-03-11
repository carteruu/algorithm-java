package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item1711_1 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>(deliciousness.length);
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        int rs = 0;
        for (int d : deliciousness) {
            Integer times = map.get(d);
            if (times != null) {
                if (times <= 1) {
                    map.remove(d);
                } else {
                    map.put(d, times - 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int sum = d + entry.getKey();
                if (sum != 0 && (sum & (sum - 1)) == 0) {
                    rs += entry.getValue();
                    rs %= 1000000007;
                }
            }
        }
        return rs;
    }
}
