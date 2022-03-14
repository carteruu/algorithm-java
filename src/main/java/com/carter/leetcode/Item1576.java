package com.carter.leetcode;

public class Item1576 {
    public String modifyString(String s) {
        int c = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i + 1 < chars.length && (char) ('a' + c) == chars[i + 1]) {
                    //不能和下一个字符相同
                    c++;
                    c %= 26;
                }
                chars[i] = (char) ('a' + c);
            } else {
                c = chars[i] - 'a';
            }
            c++;
            c %= 26;
        }
        return String.valueOf(chars);
    }
}
