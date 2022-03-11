package com.carter.leet;

public class Item1614 {
    public int maxDepth(String s) {
        int ans = 0;
        int dep = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dep++;
                ans = Math.max(ans, dep);
            } else if (c == ')') {
                dep--;
            }
        }
        return ans;
    }
}
