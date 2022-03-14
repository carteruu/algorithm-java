package com.carter.leetcode;

import java.util.HashSet;
import java.util.List;

public class Item139_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String w : wordDict) {
                if (i >= w.length() && dp[i - w.length()]) {
                    int k = i - 1;
                    boolean m = true;
                    for (int j = w.length() - 1; j >= 0; j--) {
                        if (w.charAt(j) != s.charAt(k)) {
                            m = false;
                            break;
                        }
                        k--;
                    }
                    if (m) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
