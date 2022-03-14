package com.carter.leetcode;

import java.util.*;

public class Item664 {
    int cTimes = 0;

    public int strangePrinter(String s) {
        Map<String, Integer> c = new HashMap<>((s.length() ^ 2) / 2);
        int times = strangePrinter(s, c, 0, s.length() - 1);
        System.out.println(cTimes);
        return times;
    }

    private int strangePrinter(String s, Map<String, Integer> c, int i, int j) {
        if (i == j) {
            return 1;
        }
        String key = i + "-" + j;
        if (c.containsKey(key)) {
            return c.get(key);
        }
        if (s.charAt(i) == s.charAt(j)) {
            int times = strangePrinter(s, c, i, j - 1);
            c.put(key, times);
            return times;
        }
        int minTimes = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            minTimes = Math.min(minTimes, strangePrinter(s, c, i, k) + strangePrinter(s, c, k + 1, j));
            cTimes++;
        }
        c.put(key, minTimes);
        return minTimes;
    }

    int cTimes1 = 0;

    public int strangePrinter1(String s) {
        int[][] rs = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            rs[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    rs[i][j] = rs[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, rs[i][k] + rs[k + 1][j]);
                        cTimes1++;
                    }
                    rs[i][j] = min;
                }
            }
        }
        System.out.println(cTimes1);
        return rs[0][s.length() - 1];
    }
}
