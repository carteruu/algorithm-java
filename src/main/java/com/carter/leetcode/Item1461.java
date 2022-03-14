package com.carter.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Item1461 {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        Set<String> set = new HashSet<>(1 << k);
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == 1 << k;
    }
}

//class Solution {
//    public boolean hasAllCodes(String s, int k) {
//        if (s.length() < (1 << k) + k - 1) {
//            return false;
//        }
//
//        int num = Integer.parseInt(s.substring(0, k), 2);
//        Set<Integer> exists = new HashSet<>(1 << k);
//        exists.add(num);
//
//        for (int i = 1; i + k <= s.length(); ++i) {
//            num = ((num - ((s.charAt(i - 1) - '0') << (k - 1))) << 1) + (s.charAt(i + k - 1) - '0');
//            exists.add(num);
//        }
//        return exists.size() == (1 << k);
//    }
//}
