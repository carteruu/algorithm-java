package com.carter.leet;

public class Item1486 {
    public int xorOperation(int n, int start) {
        int rs = 0;
        for (int i = 0; i < n; i++) {
            rs ^= start + 2 * i;
        }
        return rs;
    }
}
