package com.carter.leetcode;

import java.util.Arrays;

public class Item2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        boolean hasR = n % k > 0;
        String[] ans = new String[n / k + (hasR ? 1 : 0)];
        for (int i = 0; i < n / k; i++) {
            ans[i] = s.substring(i * k, (i + 1) * k);
        }
        if (hasR) {
            char[] end = new char[k];
            for (int i = 0; i < n - n / k * k; i++) {
                end[i] = s.charAt(i + n / k * k);
            }
            Arrays.fill(end, n - n / k * k, k, fill);
            ans[ans.length - 1] = String.valueOf(end);
        }
        return ans;
    }

    public String[] divideString1(String s, int k, char fill) {
        if (s.length() % k > 0) {
            StringBuilder sb = new StringBuilder(s);
            int r = k - s.length() % k;
            for (int i = 0; i < r; i++) {
                sb.append(fill);
            }
            s = sb.toString();
        }
        String[] ans = new String[s.length() / k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = s.substring(i * k, (i + 1) * k);
        }
        return ans;
    }
}
