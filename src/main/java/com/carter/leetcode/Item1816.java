package com.carter.leetcode;

public class Item1816 {
    public String truncateSentence(String s, int k) {
        int end = 0;
        while (k > 0) {
            do {
                end++;
            } while (end < s.length() && s.charAt(end) != ' ');
            k--;
        }
        return s.substring(0, end);
    }
}
