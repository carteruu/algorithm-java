package com.carter.leetcode;

public class Item14 {
    public String longestCommonPrefix(String[] strs) {
        String minStr = strs[0];
        for (int i = 0, charArrayLength = minStr.length(); i < charArrayLength; i++) {
            char c = minStr.charAt(i);
            for (int j = 1, strsLength = strs.length; j < strsLength; j++) {
                String str = strs[j];
                if (i >= str.length() || c != str.charAt(i)) {
                    return minStr.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
