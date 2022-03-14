package com.carter.leetcode;

public class Item2103 {
    public int countPoints(String rings) {
        int[] flags = new int[26];
        flags['R' - 'A'] = 1;
        flags['G' - 'A'] = 1 << 1;
        flags['B' - 'A'] = 1 << 2;
        int[] sets = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            sets[rings.charAt(i + 1) - '0'] |= flags[rings.charAt(i) - 'A'];
        }
        int cnt = 0;
        for (int num : sets) {
            if (num == 0b111) {
                cnt++;
            }
        }
        return cnt;
    }
}
