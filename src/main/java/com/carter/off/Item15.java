package com.carter.off;

public class Item15 {
    public int hammingWeight(int n) {
        int rs = 0;
        while (n != 0) {
            n = n & (n - 1);
            rs++;
        }
        return rs;
    }

    public int hammingWeight1(int n) {
        int rs = 0;
        if (n < 0) {
            n += Integer.MAX_VALUE;
            n += 1;
            rs++;
        }
        while (n > 0) {
            rs += n & 1;
            n >>= 1;
        }
        return rs;
    }

}
