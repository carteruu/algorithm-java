package com.carter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, ans, new ArrayList<>());
        return ans;
    }

    private void helper(String s, int idx, List<List<String>> ans, List<String> list) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            int left = idx;
            int right = i - 1;
            boolean is = true;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    is = false;
                    break;
                }
                left++;
                right--;
            }
            if (!is) {
                continue;
            }
            list.add(s.substring(idx, i));
            helper(s, i, ans, list);
            list.remove(list.size() - 1);
        }
    }

    class Solution {
        boolean[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }

}
