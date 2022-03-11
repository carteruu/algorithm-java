package com.carter.leet;

public class Item1446 {
    public int maxPower(String s) {
        int ans = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(l)) {
                l = i;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
