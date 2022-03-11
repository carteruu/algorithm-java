package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(ans, s.toCharArray(), 0, new ArrayList<>(4));
        return ans;
    }

    private void dfs(List<String> ans, char[] s, int charIdx, List<int[]> path) {
        if (charIdx == s.length && path.size() == 4) {
            StringBuilder ss = new StringBuilder();
            for (int j = 0; j < path.size() - 1; j++) {
                for (int i = path.get(j)[0]; i <= path.get(j)[1]; i++) {
                    ss.append(s[i]);
                }
                ss.append('.');
            }
            for (int i = path.get(3)[0]; i <= path.get(3)[1]; i++) {
                ss.append(s[i]);
            }
            ans.add(ss.toString());
        }
        if (charIdx >= s.length || path.size() == 4) {
            return;
        }
        int other = 3 - path.size();
        int re = s.length - charIdx - other;
        int min = re - 2 * other;
        int max = re;
        if (min < 1) {
            min = 1;
        }
        if (max > 3) {
            max = 3;
        }
        for (int count = min; count <= max; count++) {
            if (count > 1 && s[charIdx] == '0') {
                continue;
            }
            int end = charIdx + count;
            if (end > s.length) {
                continue;
            }
            if (count == 3 && (s[charIdx] > '2' || (s[charIdx] == '2' && s[charIdx + 1] > '5') || (s[charIdx] == '2' && s[charIdx + 1] == '5' && s[charIdx + 2] > '5'))) {
                continue;
            }
            path.add(new int[]{charIdx, end - 1});
            dfs(ans, s, end, path);
            path.remove(path.size() - 1);
        }
    }
}
