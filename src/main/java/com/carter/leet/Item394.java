package com.carter.leet;

public class Item394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb);
        return sb.toString();
    }

    private int helper(String s, int idx, StringBuilder sb) {
        if (idx >= s.length()) {
            return idx;
        }
        int num = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                idx++;
            } else if (c == '[') {
                StringBuilder ss = new StringBuilder();
                idx = helper(s, idx + 1, ss);
                for (; num > 0; num--) {
                    sb.append(ss);
                }
            } else if (c == ']') {
                idx++;
                break;
            } else {
                if (num == 0) {
                    num = 1;
                }
                for (; num > 0; num--) {
                    sb.append(c);
                }
                idx++;
            }
        }
        return idx;
    }
}
