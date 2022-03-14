package com.carter.offer;

import java.util.*;

public class Item38_1 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> ans = new ArrayList<>(s.length() * (s.length() - 1));
        helper1(chars, 0, ans);
        return ans.toArray(new String[0]);
    }

    private void helper1(char[] chars, int idx, List<String> ans) {
        if (idx == chars.length) {
            ans.add(new String(chars));
            return;
        }
        //不交换
        helper1(chars, idx + 1, ans);
        //交换
        char pre = chars[idx];
        for (int i = idx + 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                continue;
            }
            pre = chars[i];
            chars[i] = chars[idx];
            chars[idx] = pre;
            helper1(chars, idx + 1, ans);
            //还原
            chars[idx] = chars[i];
            chars[i] = pre;
        }
    }

    public String[] permutation1(String s) {
        Set<String> ans = new HashSet<>();
        helper(s, ans, new boolean[s.length()], new char[s.length()], 0);
        return ans.toArray(new String[0]);
    }

    private void helper(String s, Set<String> ans, boolean[] seen, char[] path, int idx) {
        if (idx == s.length()) {
            ans.add(new String(path));
            return;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (seen[i]) {
                continue;
            }
            seen[i] = true;
            char c = charArray[i];
            path[idx] = c;
            helper(s, ans, seen, path, idx + 1);
            seen[i] = false;
        }
    }
}
