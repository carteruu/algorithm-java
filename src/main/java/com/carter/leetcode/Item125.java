package com.carter.leetcode;

public class Item125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char cL = s.charAt(l);
            char cR = s.charAt(r);
            if (!Character.isLetterOrDigit(cL)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(cR)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(cL) == Character.toLowerCase(cR)) {
                l++;
                r--;
                continue;
            }
            return false;
        }
        return true;
    }
}
