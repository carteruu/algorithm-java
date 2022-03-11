package com.carter.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Item2063 {
    public long countVowels(String word) {
        Set<Character> cs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        long cnt = 0;
        long n = word.length();
        for (int i = 0; i < n; i++) {
            if (cs.contains(word.charAt(i))) {
                //左边包含i的子串数量*右边包含i的子串数量
                cnt += ((long) (i + 1)) * (n - i);
            }
        }
        return cnt;
    }
}
