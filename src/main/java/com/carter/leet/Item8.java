package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item8 {
    public int myAtoi(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int myAtoi1(String s) {
        long num = 0;
        int sign = 1;
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            if (s.charAt(idx) == '-') {
                sign = -1;
            }
            idx++;
        }
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                num *= 10;
                num += s.charAt(idx) - '0';
                if (sign * num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign * num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                idx++;
            } else {
                break;
            }
        }
        return (int) (sign * num);
    }

    class Solution {
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
}
