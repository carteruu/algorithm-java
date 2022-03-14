package com.carter.leetcode;

public class Item859_1 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() < 2) {
            return false;
        }
        int errCnt = 0;
        int[] sChars = new int[26];
        int[] goalChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                errCnt++;
            }
            sChars[s.charAt(i) - 'a']++;
            goalChars[goal.charAt(i) - 'a']++;
        }
        boolean hasCharCntBigger2 = false;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != goalChars[i]) {
                return false;
            }
            if (sChars[i] >= 2) {
                hasCharCntBigger2 = true;
            }
        }
        return errCnt == 2 || (hasCharCntBigger2 && errCnt == 0);
    }
}
