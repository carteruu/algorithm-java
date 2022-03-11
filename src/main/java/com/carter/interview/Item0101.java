package com.carter.interview;

import java.util.HashSet;
import java.util.Set;

public class Item0101 {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUnique1(String astr) {
        Set<Character> set = new HashSet<>(astr.length());
        for (char c : astr.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}