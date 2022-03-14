package com.carter.leetcode;

public class Item10 {
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public boolean isMatch(String s, String p) {
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        boolean[][] dp = new boolean[scs.length + 1][pcs.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= scs.length; i++) {
            for (int j = 1; j <= pcs.length; j++) {
                if (pcs[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || (matches(s, p, i, j - 1) && dp[i - 1][j]);
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[scs.length][pcs.length];
    }

    public boolean isMatch1(String s, String p) {
        return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean helper(char[] s, int si, char[] p, int pi) {
        while (checkChar(s, si, p, pi)) {
            if (pi + 1 < p.length && p[pi + 1] == '*') {
                break;
            }
            si++;
            pi++;
        }
        if (pi + 1 < p.length && p[pi + 1] == '*') {
            return helper(s, si, p, pi + 2) || (checkChar(s, si, p, pi) && helper(s, si + 1, p, pi));
        }
        return s.length == si && p.length == pi;
    }

    private boolean checkChar(char[] s, int si, char[] p, int pi) {
        return si < s.length && pi < p.length && (s[si] == p[pi] || p[pi] == '.');
    }
}
