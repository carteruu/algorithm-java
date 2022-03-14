package com.carter.leetcode;

import java.util.*;

public class Item187_1 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<Long, Integer> set = new HashMap<>();
        long hash = 0;
        long mark = (1 << 20) - 1;
        for (int i = 0; i < s.length(); i++) {
            hash <<= 2;
            hash += hash(s.charAt(i));
            if (i >= 9) {
                hash &= mark;
                Integer cnt = set.getOrDefault(hash, 0);
                if (cnt == 1) {
                    ans.add(s.substring(i - 9, i + 1));
                }
                set.put(hash, cnt + 1);
            }
        }
        return ans;
    }

    private long hash(char c) {
        switch (c) {
            case 'A': {
                return 0;
            }
            case 'C': {
                return 1;
            }
            case 'G': {
                return 2;
            }
            case 'T': {
                return 3;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (set.contains(substring)) {
                ans.add(substring);
            }
            set.add(substring);
        }
        return ans;
    }
}
