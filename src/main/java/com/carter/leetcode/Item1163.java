package com.carter.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Item1163 {

    public String lastSubstring(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 1, k = 0;
        while (r + k < cs.length) {
            if (cs[l + k] == cs[r + k]) {
                k++;
            } else if (cs[l] < cs[r + k]) {
                l = r + k;
                r = l + 1;
                k = 0;
            } else if (cs[l + k] < cs[r + k]) {
                l = r;
                r = l + 1;
                k = 0;
            } else {
                r++;
                k = 0;
            }
        }
        return s.substring(l);
    }

    public String lastSubstring2(String s) {
        List<Integer> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        char maxChar = 'a';
        for (int i = 0; i < cs.length; i++) {
            if (i > 0 && i < cs.length - 1 && cs[i] == cs[i - 1] && cs[i] == cs[i + 1]) {
                continue;
            }
            if (cs[i] == maxChar) {
                list.add(i);
            }
            if (cs[i] > maxChar) {
                maxChar = cs[i];
                list.clear();
                list.add(i);
            }
        }
        Integer start = list.stream().sorted((idx1, idx2) -> {
            while (idx1 < cs.length && idx2 < cs.length) {
                if (cs[idx2] == cs[idx1]) {
                    idx1++;
                    idx2++;
                    continue;
                }
                return cs[idx2] - cs[idx1];
            }
            return idx1 - idx2;
        }).findFirst().get();
        return s.substring(start);
    }

    public String lastSubstring1(String s) {
        int len = s.length();
        PriorityQueue<Integer> head = new PriorityQueue<>((idx1, idx2) -> {
            while (true) {
                idx1++;
                idx2++;
                if (idx1 == len) {
                    return 1;
                }
                if (idx2 == len) {
                    return -1;
                }
                if (s.charAt(idx1) == s.charAt(idx2)) {
                    continue;
                }
                return s.charAt(idx2) - s.charAt(idx1);
            }
        });
        char maxChar = 'a';
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == maxChar) {
                head.offer(i);
            }
            if (s.charAt(i) > maxChar) {
                maxChar = s.charAt(i);
                head.clear();
                head.offer(i);
            }
        }
        return s.substring(head.peek());
    }
}
