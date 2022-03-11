package com.carter.leet;

public class Item342 {
    public boolean isPowerOfFour(int n) {
        if (n < 0) {
            return false;
        }
        int count0 = 0;
        int count1 = 0;
        while (n > 0) {
            count0 += n ^ 1;
            count1 += n & 1;
            n >>= 1;
        }
        return count1 == 1 && count0 % 2 == 0;
    }
}
