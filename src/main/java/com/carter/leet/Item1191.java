package com.carter.leet;

import java.util.Arrays;

public class Item1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        long sum = 0;
        int mod = 1000000007;
        int len = arr.length;

        if (k > 1) {
            len *= 2;
        }
        long rs = 0;
        long temp = 0;
        for (int i = 0; i < len; i++) {
            int val = arr[i % arr.length];
            sum += val;
            temp += val;
            if (temp < 0) {
                temp = 0;
            } else {
                rs = Math.max(rs, temp);
            }
        }
        sum /= (len / arr.length);

        if (sum > 0 && k > 2) {
            rs += ((sum % mod) * (k - 2) % mod) % mod;
        }
        return (int) rs % mod;
    }
}
