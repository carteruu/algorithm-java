package com.carter.leetcode;

public class Item1160 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] cnts = new int[26];
        char[] cs = chars.toCharArray();
        for (char c : cs) {
            cnts[c - 'a']++;
        }
        for (String s : words) {
            int[] cnt = new int[26];
            char[] cc = s.toCharArray();
            boolean need = true;
            for (char c : cc) {
                int idx = c - 'a';
                cnt[idx]++;
                if (cnt[idx] > cnts[idx]) {
                    need = false;
                    break;
                }
            }
            if (need) {
                ans += s.length();
            }
        }
        return ans;
    }
}
