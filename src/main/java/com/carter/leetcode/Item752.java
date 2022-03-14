package com.carter.leetcode;

import java.util.*;

public class Item752 {
    private int rs = 10000;
    private Set<String> deads;
    private String target;

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains(target) || deads.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>(5000);
        queue.offer("0000");
        Set<String> seen = new HashSet<>(5000);
        seen.add("0000");
        int rs = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            rs++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                char[] chars = poll.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    String add = add(j, chars);
                    if (target.equals(add)) {
                        return rs;
                    }
                    if (!seen.contains(add) && !deads.contains(add)) {
                        queue.offer(add);
                        seen.add(add);
                    }

                    String sub = sub(j, chars);
                    if (target.equals(sub)) {
                        return rs;
                    }
                    if (!seen.contains(sub) && !deads.contains(sub)) {
                        queue.offer(sub);
                        seen.add(sub);
                    }
                }
            }

        }
        return -1;
    }

    private String add(int i, char[] chars) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (j == i) {
                if (chars[i] == '9') {
                    c = '0';
                } else {
                    c++;
                }
            }
            s.append(c);
        }
        return s.toString();
    }

    private String sub(int i, char[] chars) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (j == i) {
                if (chars[i] == '0') {
                    c = '9';
                } else {
                    c--;
                }
            }
            s.append(c);
        }
        return s.toString();
    }

    public int openLock1(String[] deadends, String target) {
        deads = new HashSet<>(Arrays.asList(deadends));
        this.target = target;
        if (deads.contains(target)) {
            return -1;
        }
        o(new int[target.length()], new HashSet<>(), 0);
        return rs == 10000 ? -1 : rs;
    }

    private void o(int[] state, Set<String> f, int count) {
        StringBuilder sb = new StringBuilder();
        for (int j : state) {
            sb.append(j);
        }

        String str = sb.toString();
        if (f.contains(str)) {
            return;
        }
        f.add(str);

        if (str.equals(target)) {
            rs = Math.min(rs, count);
            return;
        }
        if (deads.contains(str)) {
            return;
        }

        //正向
        for (int i = 0; i < state.length; i++) {
            add(state, i);
            o(state, f, count++);
            sub(state, i);

            sub(state, i);
            o(state, f, count++);
            add(state, i);
        }
    }

    private void sub(int[] state, int i) {
        state[i] -= 1;
        if (state[i] == -1) {
            state[i] = 9;
        }
    }

    private void add(int[] state, int i) {
        state[i] += 1;
        state[i] %= 10;
    }
}
