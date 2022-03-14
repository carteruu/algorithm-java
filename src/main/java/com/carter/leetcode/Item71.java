package com.carter.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Item71 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String dir : dirs) {
            if (dir == null || dir.length() == 0 || ".".equals(dir)) {
                continue;
            }
            if ("..".equals(dir)) {
                if (deque.size() > 0) {
                    deque.removeLast();
                }
                continue;
            }
            deque.push(dir);
        }
        StringBuilder ans = new StringBuilder();
        while (deque.size() > 0) {
            ans.append("/");
            ans.append(deque.removeFirst());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
