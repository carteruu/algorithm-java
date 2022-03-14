package com.carter.leetcode;

import java.util.Arrays;

public class Item1720 {
    public static void main(String[] args) {
        for (int i : new Item1720().decode(new int[]{1, 2, 3}, 1)) {
            System.out.println(i);
        }
    }

    public int[] decode(int[] encoded, int first) {
        int[] rs = Arrays.copyOf(encoded,encoded.length+1);
        rs[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            rs[i + 1] = rs[i] ^ encoded[i];
        }
        return rs;
    }
}
