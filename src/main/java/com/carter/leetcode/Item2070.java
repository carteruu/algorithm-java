package com.carter.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Item2070 {
    public int[] maximumBeauty1(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = items.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (items[mid][0] > queries[i]) {
                    r = mid - 1;
                } else if (items[mid][0] <= queries[i]) {
                    ans[i] = items[mid][1];
                    l = mid + 1;
                }
            }
        }
        return ans;
    }

    public int[] maximumBeauty(int[][] items, int[] queries){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] item : items) {
            int price = item[0];
            //上一个价格
            Map.Entry<Integer, Integer> prev = treeMap.floorEntry(price - 1);
            if (prev == null || (prev.getValue() < item[1])) {
                treeMap.put(price, item[1]);
                //下一个价格
                Map.Entry<Integer, Integer> next = treeMap.ceilingEntry(price + 1);
                while (next != null && next.getValue() <= item[1]) {
                    treeMap.remove(next.getKey());
                    next = treeMap.ceilingEntry(price + 1);
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(queries[i]);
            if (entry != null) {
                result[i] = entry.getValue();
            }
        }
        return result;
    }
}
