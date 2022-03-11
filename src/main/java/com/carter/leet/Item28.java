package com.carter.leet;

public class Item28 {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }
        if (haystack == null) {
            return -1;
        }
        int lenH = haystack.length();
        int lenN = needle.length();
        if (lenN > lenH) {
            return -1;
        }
        int idx = -1;
        for (int i = 0; i < lenH - lenN + 1; i++) {
            for (int j = 0; j < lenN; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == 0) {
                        idx = i;
                    }
                } else {
                    idx = -1;
                    break;
                }
            }
            if (idx != -1) {
                return idx;
            }
        }
        return idx;
    }
}
