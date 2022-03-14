package com.carter.leetcode;

import java.util.Arrays;

public class Item1423 {
    public int maxScore(int[] cardPoints, int k) {
        int pre = 0;
        int remainLen = cardPoints.length - k;
        for (int i = 0; i < remainLen; i++) {
            pre += cardPoints[i];
        }
        int min = pre;
        for (int i = 1; i < k; i++) {
            min = Math.min(min, pre - cardPoints[i - 1] + cardPoints[i + remainLen - 1]);
        }
        return Arrays.stream(cardPoints).sum() - min;
    }
}
