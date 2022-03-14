package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item1745 {
    public boolean checkPartitioning(String s) {
        //计算所有连续子字符串是否为回文字符串
        boolean[][] arr = new boolean[s.length()][s.length()];
        //先计算所有不能根据其他值推算的值:字符串长度为1和2的情况
        for (int i = 0; i < s.length(); i++) {
            arr[i][i] = true;
            if (i + 1 < s.length()) {
                arr[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        //start:子字符串开始下标
        //end:子字符串结束下标
        // 递推格式:去掉首尾字符后的字符为回文字符串,且首尾字符相同.所以需要start需要从大到小遍历,end需要从小到大遍历
        for (int start = s.length() - 3; start >= 0; start--) {
            for (int end = start + 2; end < s.length(); end++) {
                arr[start][end] = arr[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
            }
        }
        for (int i = 0; i < s.length() - 2; i++) {
            if (arr[0][i]) {
                //第一个字符串为回文字符串
                for (int j = i + 1; j < s.length() - 1; j++) {
                    if (arr[i + 1][j] && arr[j + 1][s.length() - 1]) {
                        //第二第三个字符串为回文字符串
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkPartitioning1(String s) {
        Map<Long, Boolean> map = new HashMap<>(s.length() * s.length() / 2);
        for (int i = s.length() - 3; i >= 0; i--) {
            if (isPartitioning(s, 0, i, map)) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    if (isPartitioning(s, i + 1, j, map)) {
                        if (isPartitioning(s, j + 1, s.length() - 1, map)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isPartitioning(String s, int start, int end, Map<Long, Boolean> map) {
        if (start >= end) {
            return true;
        }
        Long key = (long) start * s.length() + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        boolean b = s.charAt(start) == s.charAt(end) && isPartitioning(s, start + 1, end - 1, map);
        map.put(key, b);
        return b;
    }
}
