package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item5917 {
    /**
     * 缓存结果,避免重复计算
     */
    private Map<String, Boolean> cache;

    public boolean possiblyEquals(String s1, String s2) {
        cache = new HashMap<>(s1.length() * s2.length());
        return helper(s1, s2, 0, 0, 0);
    }

    /**
     * @param s1
     * @param s2
     * @param idx1 字符串1当前匹配的字符下标
     * @param idx2 字符串2当前匹配的字符下标
     * @param d    原字符串s1[:idx1]比s2[:idx2]长的字符数量,可以为负数
     * @return
     */
    private boolean helper(String s1, String s2, int idx1, int idx2, int d) {
        if (idx1 == s1.length() && d == 0) {
            //完全匹配
            return idx2 == s2.length();
        }
        //当前状态的键
        String key = idx1 + "*" + idx2 + "*" + d;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (d == 0 && idx1 < s1.length() && idx2 < s2.length() && !isNum(s1.charAt(idx1)) && !isNum(s2.charAt(idx2))) {
            //s1[:idx1]比s2[:idx2]的原字符长度相同,且当前字符为相同字母
            cache.put(key, s1.charAt(idx1) == s2.charAt(idx2) && helper(s1, s2, idx1 + 1, idx2 + 1, 0));
            return cache.get(key);
        }
        if (d > 0 && idx2 < s2.length() && !isNum(s2.charAt(idx2))) {
            //s1[:idx1]比s2[:idx2]长,且s2的当前字符为字母
            cache.put(key, helper(s1, s2, idx1, idx2 + 1, d - 1));
            return cache.get(key);
        }

        if (d < 0 && idx1 < s1.length() && !isNum(s1.charAt(idx1))) {
            //s1[:idx1]比s2[:idx2]短,且s1的当前字符为字母
            cache.put(key, helper(s1, s2, idx1 + 1, idx2, d + 1));
            return cache.get(key);
        }
        //判断s1当前字符和下一个字符...是否为连续数字,是则将其转换为数字,增大d
        for (int i = idx1; i < s1.length() && isNum(s1.charAt(i)); i++) {
            if (helper(s1, s2, i + 1, idx2, d + Integer.parseInt(s1.substring(idx1, i + 1)))) {
                cache.put(key, true);
                return true;
            }
        }
        //判断s2当前字符和下一个字符...是否为连续数字,是则将其转换为数字,减少d
        for (int i = idx2; i < s2.length() && isNum(s2.charAt(i)); i++) {
            if (helper(s1, s2, idx1, i + 1, d - Integer.parseInt(s2.substring(idx2, i + 1)))) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }


    public static class Solution {

        public boolean possiblyEquals(String s1, String s2) {
            return possiblyEquals(0, 0, 0, 0, s1, s2, new HashMap<>());
        }

        private boolean possiblyEquals(int i, int j, int n, int m, String s1, String s2, HashMap<String, Boolean> map) {
            if (i == s1.length() && n == 0) {
                return j == s2.length() && m == 0;
            } else if (j == s2.length() && m == 0) {
                return false;
            } else if (n > 0 && m > 0) {
                return possiblyEquals(i, j, n - Math.min(n, m), m - Math.min(n, m), s1, s2, map);
            } else if (n > 0) {
                if (s2.charAt(j) >= 'a' && s2.charAt(j) <= 'z') {
                    return possiblyEquals(i, j + 1, n - 1, m, s1, s2, map);
                } else if (!map.containsKey(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2)) {
                    map.put(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2, false);
                    for (int k = j; k < s2.length() && s2.charAt(k) >= '0' && s2.charAt(k) <= '9'; k++) {
                        if (possiblyEquals(i, k + 1, n, Integer.parseInt(s2.substring(j, k + 1)), s1, s2, map)) {
                            map.put(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2, true);
                            break;
                        }
                    }
                }
                return map.get(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2);
            } else if (m > 0) {
                return possiblyEquals(j, i, m, n, s2, s1, map);
            } else if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                if (!map.containsKey(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2)) {
                    map.put(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2, false);
                    for (int k = i; k < s1.length() && s1.charAt(k) >= '0' && s1.charAt(k) <= '9'; k++) {
                        if (possiblyEquals(k + 1, j, Integer.parseInt(s1.substring(i, k + 1)), m, s1, s2, map)) {
                            map.put(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2, true);
                            break;
                        }
                    }
                }
                return map.get(i + " " + j + " " + n + " " + m + " " + s1 + " " + s2);
            } else if (s2.charAt(j) >= '0' && s2.charAt(j) <= '9') {
                return possiblyEquals(j, i, m, n, s2, s1, map);
            } else {
                return s1.charAt(i) == s2.charAt(j) && possiblyEquals(i + 1, j + 1, 0, 0, s1, s2, map);
            }
        }
    }
}
