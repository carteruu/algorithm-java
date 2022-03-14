package com.carter.leetcode;

public class Item2000 {
    public String reversePrefix(String word, char ch) {
        char[] cs = new char[word.length()];
        int right = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cs[i] = c;
            if (right == -1 && c == ch) {
                right = i;
            }
        }
        int left = 0;
        while (left < right) {
            char t = cs[left];
            cs[left] = cs[right];
            cs[right] = t;
            left++;
            right--;
        }
        return String.valueOf(cs);
    }
}
