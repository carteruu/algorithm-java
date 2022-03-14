package com.carter.leetcode;

import java.math.BigInteger;

public class Item2183 {
    public long coutPairs(int[] nums, int k) {
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        Long dp[] = new Long[100001], result = 0L;
        for (int num : nums) {
            int gcd = k / BigInteger.valueOf(num).gcd(BigInteger.valueOf(k)).intValue();
            if (dp[gcd] == null) {
                dp[gcd] = 0L;
                for (int i = gcd; i <= 100000; i += gcd) {
                    dp[gcd] += count[i];
                }
            }
            result += dp[gcd] - (num % gcd > 0 ? 0 : 1);
        }
        return result / 2;
    }

    public long coutPairs2(int[] nums, int k) {
        int[] cnt = new int[10001];
        long ans = 0;
        for (int num : nums) {
            int gcd = gcd(num, k);
            for (int i = 1; i <= gcd; i++) {
                if (num % i == 0 && k % i == 0) {
                    ans += cnt[k / i];
                }
            }
            cnt[gcd]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
