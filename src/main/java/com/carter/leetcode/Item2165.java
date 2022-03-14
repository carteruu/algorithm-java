package com.carter.leetcode;

import java.util.Arrays;

public class Item2165 {
    public long smallestNumber(long num) {
        //分正数和负数两种情况
        char[] chars = (Math.abs(num) + "").toCharArray();
        Arrays.sort(chars);
        if (num > 0) {
            if (chars[0] == '0') {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != '0') {
                        chars[0] = chars[i];
                        chars[i] = '0';
                        break;
                    }
                }
            }
            return Long.parseLong(String.copyValueOf(chars));
        } else if (num < 0) {
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
            return -Long.parseLong(String.copyValueOf(chars));
        } else {
            return 0;
        }
    }
}
