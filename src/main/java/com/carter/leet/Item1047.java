package com.carter.leet;

import java.util.LinkedList;

public class Item1047 {
    public String removeDuplicates(String s) {
        char[] sc = s.toCharArray();
        int idx = -1;
        for (char c : sc) {
            if (idx == -1 || sc[idx] != c) {
                sc[++idx] = c;
            } else {
                idx--;
            }
        }
        return new String(sc, 0, idx + 1);
    }

    public String removeDuplicates2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        char[] cs = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            cs[i] = stack.pop();
        }
        return new String(cs);
    }

    public String removeDuplicates1(String s) {
        if (s == null) {
            return null;
        }
        return helper(new StringBuilder(s)).toString();
    }

    private StringBuilder helper(StringBuilder sb) {
        if (sb.length() <= 1) {
            return sb;
        }
        StringBuilder ss = new StringBuilder();
        char pre = sb.charAt(0);
        for (int i = 1; i < sb.length(); i++) {
            if (pre == 'A') {
                pre = sb.charAt(i);
                continue;
            }
            if (pre != sb.charAt(i)) {
                ss.append(pre);
                pre = sb.charAt(i);
            } else {
                pre = 'A';
            }
        }
        if (pre != 'A') {
            ss.append(pre);
        }
        if (ss.length() == sb.length()) {
            return ss;
        } else {
            return helper(ss);
        }
    }
}
