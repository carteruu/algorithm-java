package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item859 {
    public boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() < 2) {
            return false;
        }
        int diff = 0;
        Character diffCharS = null;
        Character diffCharGoal = null;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (diff == 1) {
                    diffCharS = s.charAt(i);
                    diffCharGoal = goal.charAt(i);
                } else if (diff == 2) {
                    if (diffCharS != goal.charAt(i) || diffCharGoal != s.charAt(i)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (diff == 2) {
            return true;
        }
        if (diff == 0) {
            for (Integer val : map) {
                if (val >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
