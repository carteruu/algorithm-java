package com.carter.leet;

import java.util.*;

public class Item520 {
    public boolean detectCapitalUse(String word) {
        Map<String, Set<String>> steps = new HashMap<String, Set<String>>() {
            {
                this.put("first-upper", new HashSet<>(Arrays.asList("lower", "upper", "end")));
                this.put("first-lower", new HashSet<>(Arrays.asList("lower", "end")));
                this.put("lower", new HashSet<>(Arrays.asList("lower", "end")));
                this.put("upper", new HashSet<>(Arrays.asList("upper", "end")));
            }
        };

        String state;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            state = "first-upper";
        } else {
            state = "first-lower";
        }
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            String s;
            if (c >= 'A' && c <= 'Z') {
                s = "upper";
            } else {
                s = "lower";
            }
            if (!steps.get(state).contains(s)) {
                return false;
            }
            state = s;
        }
        return true;
    }
}
