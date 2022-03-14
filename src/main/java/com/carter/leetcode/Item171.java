package com.carter.leetcode;

public class Item171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        char[] chars = columnTitle.toCharArray();
        for (char c : chars) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }
}
