package com.carter.leetcode;

public class Item1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            int t = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);
            if (t > max || (t == max && c > ans)) {
                ans = c;
                max = t;
            }
        }
        return ans;
    }
}
