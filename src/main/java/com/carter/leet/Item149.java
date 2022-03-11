package com.carter.leet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Item149 {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int rs = 0;
        for (int i = 0; i < points.length; i++) {
            if (rs > points.length - i) {
                break;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //x-x
                int q = points[i][0] - points[j][0];
                int w = points[i][1] - points[j][1];
                String key;
                if (q == 0) {
                    key = "x-" + (points[i][1]);
                } else if (w == 0) {
                    key = points[i][0] + "-y";
                } else {
                    if (w < 0) {
                        q = -q;
                        w = -w;
                    }
                    int gcd = getGCD(w, q);
                    String s = (q / gcd) + "-" + (w / gcd);
                    key = s + "-" + (points[i][1] - points[i][0]);
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (int count : map.values()) {
                rs = Math.max(rs, count + 1);
            }
            if (rs > points.length / 2) {
                //超过半数
                break;
            }
        }
        return rs;
    }

    private static int getGCD(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
