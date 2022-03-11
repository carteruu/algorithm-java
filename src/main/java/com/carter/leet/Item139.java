package com.carter.leet;

import java.util.List;

public class Item139 {
    private static class Node {
        public boolean idEnd;
        public Node[] cs;
        public char c;

        public Node(boolean idEnd, char c) {
            this.idEnd = idEnd;
            this.c = c;
            this.cs = new Node[26 * 2];
        }

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node(false, '/');
        for (String w : wordDict) {
            char[] chars = w.toCharArray();
            Node cur = root;
            for (char c : chars) {
                int idx = getIdx(c);
                if (cur.cs[idx] == null) {
                    cur.cs[idx] = new Node(false, c);
                }
                cur = cur.cs[idx];
            }
            cur.idEnd = true;
        }

        return match(s.toCharArray(), 0, root, root);
    }

    private int getIdx(char c) {
        int idx = c - 'A';
        if (idx >= 26) {
            return c - 'a' + 26;
        }
        return idx;
    }

    private boolean match(char[] chars, int idx, Node root, Node pre) {
        if (idx == chars.length) {
            return pre.idEnd;
        }
        while (idx < chars.length) {
            pre = pre.cs[getIdx(chars[idx])];
            if (pre == null) {
                return false;
            }
            idx++;
            if (pre.idEnd) {
                if (match(chars, idx, root, root)) {
                    return true;
                }
            }
        }
        return pre.idEnd;
    }
}
