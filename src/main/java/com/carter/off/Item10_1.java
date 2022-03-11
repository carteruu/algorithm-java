package com.carter.off;

public class Item10_1 {
    public int fib(int n) {
        int mod = 1000000007;
        if (n <= 1) {
            return n;
        }
        int prepre = 0;
        int pre = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (prepre + pre) % mod;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
