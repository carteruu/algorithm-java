package com.carter.leet;

import java.util.HashSet;
import java.util.Set;

public class Item1044 {
    public String longestDupSubstring(String s) {
        long y = 1313131;
        long[] pre = new long[s.length() + 1];
        long[] pow = new long[s.length() + 1];
        pre[0] = 0;
        pow[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            pre[i + 1] = pre[i] * y + s.charAt(i) - 'a';
            pow[i + 1] = pow[i] * y;
        }
        int l = 1, r = s.length() - 1;
        String ans = "";
        while (l <= r) {
            int mid = (l + r) >> 1;
            String check = check(s, mid, pre, pow);
            if (check != null) {
                ans = check;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private String check(String s, int len, long[] pre, long[] pow) {
        Set<Long> set = new HashSet<>(s.length() - len);
        for (int end = len - 1; end < s.length(); end++) {
            Long hash = pre[end + 1] - pre[end - len + 1] * pow[len];
            if (set.contains(hash)) {
                return s.substring(end - len + 1, end + 1);
            }
            set.add(hash);
        }
        return null;
    }

    public String longestDupSubstring1(String s) {
        char[] chars = s.toCharArray();
        int dupStart = 0;
        int dupLen = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                int l = 0;
                for (; l < chars.length - j; l++) {
                    if (chars[i + l] != chars[j + l]) {
                        break;
                    }
                }
                if (l > dupLen) {
                    dupStart = i;
                    dupLen = l;
                }
            }
        }
        return s.substring(dupStart, dupStart + dupLen);
    }
}
