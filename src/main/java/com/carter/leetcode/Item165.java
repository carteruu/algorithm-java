package com.carter.leetcode;

public class Item165 {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int i = 0;
        while (i < strs1.length && i < strs2.length) {
            int num1 = Integer.parseInt(strs1[i]);
            int num2 = Integer.parseInt(strs2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
        }
        int i1 = i;
        int i2 = i;
        while (i1 < strs1.length) {
            if (Integer.parseInt(strs1[i1]) > 0) {
                return 1;
            }
            i1++;
        }
        while (i2 < strs2.length) {
            if (Integer.parseInt(strs2[i2]) > 0) {
                return -1;
            }
            i2++;
        }
        return 0;
    }
}
