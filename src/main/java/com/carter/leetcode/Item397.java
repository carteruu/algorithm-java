package com.carter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item397 {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n /= 2;
                ans++;
            } else if (n % 4 == 1) {
                n /= 2;
                ans += 2;
            } else {
                ans += 2;
                if (n == 3) {
                    n = 1;
                } else {
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

    public int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (n <= 0) {
            return Integer.MAX_VALUE;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if ((n & 1) == 0) {
            cache.put(n, integerReplacement(n >> 1) + 1);
        } else {
            //奇数:加1再除以2 = 除以2再加1
            //奇数:减1再除以2 = 除以2
            cache.put(n, Math.min(integerReplacement(n / 2 + 1), integerReplacement(n / 2)) + 2);
        }
        return cache.get(n);
    }
}
