package com.carter.leetcode;

public class Item1220 {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * @param n
     * @return
     */
    public int countVowelPermutation(int n) {
        //n为1时,以aeiou结尾的字符串个数都为1
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        for (int j = 1; j < n; j++) {
            //a的前一个字母为eiu
            long ta = e + i + u;
            //e的前一个字母为ai
            long te = a + i;
            //i的前一个字母为eo
            long ti = e + o;
            //o的前一个字母为i
            long to = i;
            //u的前一个字母为io
            long tu = i + o;

            a = ta % MOD;
            e = te % MOD;
            i = ti % MOD;
            o = to % MOD;
            u = tu % MOD;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}
