package com.carter.leet;

public class Item5 {
    public String longestPalindrome(String s) {
        int max = 1;
        int start = 0;
        int end = 0;
        boolean[][] arr = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            arr[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                arr[i][j] = s.charAt(i) == s.charAt(j) && (arr[i + 1][j - 1] || j - i == 1);
                int len = j - i + 1;
                if (arr[i][j] && len > max) {
                    max = len;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
