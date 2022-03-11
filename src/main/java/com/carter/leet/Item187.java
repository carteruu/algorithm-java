package com.carter.leet;

import java.util.*;

public class Item187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        if (s.length() < len) {
            return new ArrayList<>();
        }
        Set<String> ans = new HashSet<>();
        Set<Long> map = new HashSet<>(s.length() - len + 1);
        for (int i = 0; i <= s.length() - len; i++) {
            long mark = 0L;
            for (int j = 0; j < len; j++) {
                char c = s.charAt(i + j);
                //'A'，'C'，'G' 和 'T'
                switch (c) {
                    case 'A': {
                        mark |= 1L << j * 4;
                        break;
                    }
                    case 'C': {
                        mark |= 1L << j * 4 + 1;
                        break;
                    }
                    case 'G': {
                        mark |= 1L << j * 4 + 2;
                        break;
                    }
                    case 'T': {
                        mark |= 1L << j * 4 + 3;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            }
            if (map.contains(mark)) {
                ans.add(s.substring(i, i + len));
            } else {
                map.add(mark);
            }
        }
        return new ArrayList<>(ans);
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> set = new HashSet<>(s.length() - 9);
        Set<String> ans = new HashSet<>();
        int len = 10;
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (set.contains(sub)) {
                ans.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(ans);
    }

    class Solution {
        static final int len = 10;
        Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ans = new ArrayList<>();
            int n = s.length();
            if (n <= len) {
                return ans;
            }
            int x = 0;
            for (int i = 0; i < len - 1; ++i) {
                x = (x << 2) | bin.get(s.charAt(i));
            }
            Map<Integer, Integer> cnt = new HashMap<>(n - len + 1);
            int mark = (1 << (len * 2)) - 1;
            for (int i = 0; i <= n - len; ++i) {
                x = ((x << 2) | bin.get(s.charAt(i + len - 1))) & mark;
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                if (cnt.get(x) == 2) {
                    ans.add(s.substring(i, i + len));
                }
            }
            return ans;
        }
    }

    class Solution1 {
        int N = (int) 1e5 + 10, P = 131313;
        int[] h = new int[N], p = new int[N];

        public List<String> findRepeatedDnaSequences(String s) {
            int n = s.length();
            List<String> ans = new ArrayList<>();
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                h[i] = h[i - 1] * P + s.charAt(i - 1);
                p[i] = p[i - 1] * P;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i + 10 - 1 <= n; i++) {
                int j = i + 10 - 1;
                int hash = h[j] - h[i - 1] * p[j - i + 1];
                int cnt = map.getOrDefault(hash, 0);
                if (cnt == 1) {
                    ans.add(s.substring(i - 1, i + 10 - 1));
                }
                map.put(hash, cnt + 1);
            }
            return ans;
        }
    }
}
