package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item299 {
    public String getHint(String secret, String guess) {
        int bullsCnt = 0;
        int cowsCnt = 0;
        int[] numCnt = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                //数字和位置都相同
                bullsCnt++;
            } else {
                //数字相同,但位置不同
                if (numCnt[s - '0'] < 0) {
                    cowsCnt++;
                }
                if (numCnt[g - '0'] > 0) {
                    cowsCnt++;
                }
                numCnt[s - '0']++;
                numCnt[g - '0']--;
            }
        }
        return String.format("%dA%dB", bullsCnt, cowsCnt);
    }

    public String getHint1(String secret, String guess) {
        boolean[] bulls = new boolean[secret.length()];
        int bullsCnt = 0;
        int cowsCnt = 0;

        Map<Character, Integer> secretMap = new HashMap<>(secret.length());
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                bulls[i] = true;
                bullsCnt++;
            } else {
                secretMap.put(c, secretMap.getOrDefault(c, 0) + 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (bulls[i]) {
                //已经完全匹配
                continue;
            }
            char c = guess.charAt(i);
            if (secretMap.getOrDefault(c, 0) > 0) {
                secretMap.put(c, secretMap.get(c) - 1);
                cowsCnt++;
            }
        }
        return String.format("%dA%dB", bullsCnt, cowsCnt);
    }
}
