package com.carter.leetcode;

import java.util.Arrays;

public class Item43 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 1 && num1.charAt(0) == '0' || n2 == 1 && num2.charAt(0) == '0') {
            return "0";
        }
        char[] res = new char[n1 + n2];
        Arrays.fill(res, '0');
        for (int i = n1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int idx = i + j + 1;
                int y = num2.charAt(j) - '0';
                res[idx] += x * y;
                int z = res[idx] - '0';
                res[idx] -= z / 10 * 10;
                res[idx - 1] += z / 10;
            }
        }
        if (res[0] == '0') {
            return new String(res, 1, res.length - 1);
        }
        return new String(res);
    }
}
