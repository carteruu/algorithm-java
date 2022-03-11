package com.carter.leet;

import java.util.Arrays;
import java.util.Comparator;

public class Item748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] cnts = new int[26];
        int allCnt = 0;
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if ('a' <= c && c <= 'z') {
                cnts[c - 'a']++;
            } else if ('A' <= c && c <= 'Z') {
                cnts[c - 'A']++;
            } else {
                continue;
            }
            allCnt++;
        }
        for (String word : words) {
            int[] tempCnt = new int[cnts.length];
            int tempAllCnt = allCnt;
            System.arraycopy(cnts, 0, tempCnt, 0, cnts.length);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if ('a' <= c && c <= 'z' && tempCnt[c - 'a'] > 0) {
                    tempCnt[c - 'a']--;
                } else if ('A' <= c && c <= 'Z' && tempCnt[c - 'A'] > 0) {
                    tempCnt[c - 'A']--;
                } else {
                    continue;
                }
                tempAllCnt--;
            }
            if (tempAllCnt == 0) {
                return word;
            }
        }
        return null;
    }
}
