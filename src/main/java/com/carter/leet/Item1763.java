package com.carter.leet;

public class Item1763 {
    public String longestNiceSubstring(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int err = 0;
            boolean[] low = new boolean[26];
            boolean[] upper = new boolean[26];
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if ('a' <= c && c <= 'z') {
                    int idx = c - 'a';
                    if (!low[idx]) {
                        //如果大学的存在,则错误数量-1;否则+1
                        err += upper[idx] ? -1 : 1;
                    }
                    low[idx] = true;
                } else {
                    int idx = c - 'A';
                    if (!upper[idx]) {
                        err += low[idx] ? -1 : 1;
                    }
                    upper[idx] = true;
                }
                if (err == 0 && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
