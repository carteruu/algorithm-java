package com.carter.leet;

import java.util.*;

public class Item472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode(26);
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (dfs(root, new boolean[word.length()], word, 0)) {
                ans.add(word);
            } else {
                TrieNode parent = root;
                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (parent.children[idx] == null) {
                        parent.children[idx] = new TrieNode(26);
                    }
                    parent = parent.children[idx];
                }
                parent.isEnd = true;
            }
        }
        return ans;
    }

    private boolean dfs(TrieNode root, boolean[] visited, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (visited[idx]) {
            return false;
        }
        TrieNode curr = root;
        for (int i = idx; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            if (curr == null) {
                return false;
            }
            if (curr.isEnd && dfs(root, visited, word, i + 1)) {
                return true;
            }
        }
        return false;
    }
}

class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;

    public TrieNode(int num) {
        this.children = new TrieNode[num];
    }
}
