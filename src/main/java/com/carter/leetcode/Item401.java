package com.carter.leetcode;

import java.util.*;

public class Item401 {
    private final int[] hours = new int[]{1, 2, 4, 8};
    private final int[] mins = new int[]{1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        Set<String> rs = new HashSet<>();
        int times = Math.min(turnedOn, hours.length - 1);
        for (int i = 0; i <= times; i++) {
            boolean[] hour = new boolean[12];
            hourC(i, 0, 0, hour);

            boolean[] min = new boolean[60];
            if (turnedOn - i >= 0) {
                minC(turnedOn - i, 0, 0, min);
            }

            for (int j = 0; j < hour.length; j++) {
                if (hour[j]) {
                    for (int k = 0; k < min.length; k++) {
                        if (min[k]) {
                            rs.add(j + ":" + String.format("%02d", k));
                        }
                    }
                }
            }
        }
        ArrayList<String> strings = new ArrayList<>(rs);
        strings.sort(String::compareTo);
        return strings;
    }

    private void hourC(int turnedOn, int idx, int num, boolean[] rs) {
        if (num >= rs.length) {
            return;
        }
        if (turnedOn == 0) {
            rs[num] = true;
            return;
        }
        if (idx == hours.length) {
            return;
        }
        hourC(turnedOn, idx + 1, num, rs);
        hourC(turnedOn - 1, idx + 1, num + hours[idx], rs);
    }

    private void minC(int turnedOn, int idx, int num, boolean[] rs) {
        if (num >= rs.length) {
            return;
        }
        if (turnedOn == 0) {
            rs[num] = true;
            return;
        }
        if (idx == mins.length) {
            return;
        }
        minC(turnedOn, idx + 1, num, rs);
        minC(turnedOn - 1, idx + 1, num + mins[idx], rs);
    }
}
