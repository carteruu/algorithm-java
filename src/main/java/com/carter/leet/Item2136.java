package com.carter.leet;

import java.util.Arrays;

public class Item2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Integer[] index = new Integer[growTime.length];
        int max = 0;
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        //按生长时间倒序
        Arrays.sort(index, (o1, o2) -> growTime[o2] - growTime[o1]);
        for (int i = 0, sum = 0; i < index.length; i++) {
            sum += plantTime[index[i]];
            max = Math.max(max, sum + growTime[index[i]]);
        }
        return max;
    }
}
