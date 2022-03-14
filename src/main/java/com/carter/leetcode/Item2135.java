package com.carter.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Item2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>(startWords.length);
        for (String s : startWords) {
            int mark = 0;
            for (int i = 0; i < s.length(); i++) {
                mark |= 1 << (s.charAt(i) - 'a');
            }
            set.add(mark);
        }
        int ans = 0;
        for (String s : targetWords) {
            int mark = 0;
            for (int i = 0; i < s.length(); i++) {
                mark |= 1 << (s.charAt(i) - 'a');
            }
            for (int i = 0; i < s.length(); i++) {
                //删除一个字符
                if (set.contains(mark ^ (1 << (s.charAt(i) - 'a')))) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public int wordCount1(String[] startWords, String[] targetWords) {
        //根节点,构造trie树
        TrieNode root = new TrieNode();
        for (String s : startWords) {
            char[] cs = s.toCharArray();
            //因为可以重排,所以这里进行排序
            Arrays.sort(cs);
            TrieNode curr = root;
            for (char c : cs) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        int ans = 0;
        //遍历每一个target中的字符串,判断是否满足要求
        for (String t : targetWords) {
            char[] cs = t.toCharArray();
            //排序
            Arrays.sort(cs);
            if (dfs(root, cs, 0, false)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 深度优先搜索
     *
     * @param parent 父节点节点
     * @param cs
     * @param idx
     * @param add
     * @return
     */
    private boolean dfs(TrieNode parent, char[] cs, int idx, boolean add) {
        //已遍历完字符串,判断是否增加了一个字符,并且匹配startWords中的字符串
        if (idx == cs.length) {
            return add && parent.isEnd;
        }
        //当前节点,不为空时,可以进入下一个字符
        TrieNode curr = parent.children[cs[idx] - 'a'];
        if (curr != null) {
            if (dfs(curr, cs, idx + 1, add)) {
                return true;
            }
        }
        //未追加字符时,可以选择增加一个字符(即跳过当前字符)
        return !add && dfs(parent, cs, idx + 1, true);
    }

    /**
     * trie树
     */
    private static class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}