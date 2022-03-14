package com.carter.leetcode;

import java.util.*;

public class Item2047 {
    public int countValidWords(String sentence) {
        int ans = 0;
        Map<String, Set<String>> fsm = new HashMap<>();
        fsm.put("start", new HashSet<>(Arrays.asList("l", "f")));
        fsm.put("l", new HashSet<>(Arrays.asList("l", "-", "f", "end")));
        fsm.put("-", new HashSet<>(Arrays.asList("l")));
        fsm.put("f", new HashSet<>(Arrays.asList("end")));

        String[] strs = sentence.split(" ");
        for (String str : strs) {
            String state = "start";
            int i = 0;
            //连字符数量
            int _cnt = 0;
            for (; i < str.length(); i++) {
                Set<String> next = fsm.getOrDefault(state, new HashSet<>());
                char c = str.charAt(i);
                if ('a' <= c && c <= 'z') {
                    state = "l";
                } else if (c == '-') {
                    state = "-";
                    _cnt++;
                } else if (c == '!' || c == '.' || c == ',') {
                    state = "f";
                } else {
                    state = "err";
                }
                if (!next.contains(state)) {
                    state = "err";
                    break;
                }
            }
            //连字符最多只能有一个,最后一个字符可以是末尾
            if (_cnt <= 1 && fsm.getOrDefault(state, new HashSet<>()).contains("end")) {
                ans++;
            }
        }
        return ans;
    }
}
