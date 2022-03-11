package com.carter.leet;

public class Item2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] ctns = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            ctns[word1.charAt(i) - 'a']++;
            ctns[word2.charAt(i) - 'a']--;
        }
        for (int ctn : ctns) {
            if (ctn > 3 || ctn < -3) {
                return false;
            }
        }
        return true;
    }
}
