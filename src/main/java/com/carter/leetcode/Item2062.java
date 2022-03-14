package com.carter.leetcode;

import java.util.*;

public class Item2062 {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        Set<Character> cs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> cns;
        for (int i = 0; i < word.length(); i++) {
            cns = new HashSet<>();
            int r = i;
            while (r < word.length() && cs.contains(word.charAt(r))) {
                cns.add(word.charAt(r));
                if (cns.size() == cs.size()) {
                    ans++;
                }
                r++;
            }
        }
        return ans;
    }
}
