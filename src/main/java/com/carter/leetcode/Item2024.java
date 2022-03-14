package com.carter.leetcode;

public class Item2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0;
        int slow = 0;
        int k1 = k;
        for (int fast = 0; fast < answerKey.length(); fast++) {
            if (answerKey.charAt(fast) != 'T') {
                k1--;
            }
            while (k1 < 0 && slow <= fast) {
                if (answerKey.charAt(slow) == 'F') {
                    k1++;
                }
                slow++;
            }
            ans = Math.max(ans, fast - slow + 1);
        }

        k1 = k;
        slow = 0;
        for (int fast = 0; fast < answerKey.length(); fast++) {
            if (answerKey.charAt(fast) != 'F') {
                k1--;
            }
            while (k1 < 0 && slow <= fast) {
                if (answerKey.charAt(slow) == 'T') {
                    k1++;
                }
                slow++;
            }
            ans = Math.max(ans, fast - slow + 1);
        }
        return ans;
    }
}
