package com.carter.leet;

import java.util.Arrays;

public class Item1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s = Math.min(start, destination);
        int e = Math.max(start, destination);
        //顺序
        int rs1 = 0;
        for (int i = s; i < e; i++) {
            rs1 += distance[i];
        }
        return Math.min(rs1, Arrays.stream(distance).sum() - rs1);
    }
}
