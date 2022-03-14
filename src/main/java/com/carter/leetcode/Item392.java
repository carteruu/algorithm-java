package com.carter.leetcode;

public class Item392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        //缓存下一个字母所在的位置
        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[m][i] = -1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int idxDp = 0;
        for (int i = 0; i < n; i++) {
            int next = dp[idxDp][s.charAt(i) - 'a'];
            if (next == -1) {
                return false;
            }
            idxDp = next+1;
        }
        return true;
    }

    /**
     * 贪心
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        if (t.length() == 0) {
            return s.length() == 0;
        }
        int idxT = 0;
        for (int i = 0; i < s.length(); i++) {
            while (s.charAt(i) != t.charAt(idxT)) {
                idxT++;
                if (idxT == t.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 回溯,这里不需要回溯,贪心就可以解决
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        return helper(s, t, 0, 0);
    }

    private boolean helper(String s, String t, int idxS, int idxT) {
        if (idxS == s.length()) {
            return true;
        }
        if (idxT == t.length()) {
            return false;
        }
        boolean res = false;
        if (s.charAt(idxS) == t.charAt(idxT)) {
            //匹配
            res = helper(s, t, idxS + 1, idxT + 1);
        }
        //不匹配
        return res || helper(s, t, idxS, idxT + 1);
    }
}
