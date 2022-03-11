package com.carter.leet;

public class item2156 {

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] ps = new long[k];
        ps[0] = 1;
        for (int i = 1; i < k; i++) {
            ps[i] = ps[i - 1] * power % modulo;
        }
        for (int i = 0; i <= s.length() - k; i++) {
            long hash = 0;
            for (int j = 0; j < k; j++) {
                hash = (hash + (s.charAt(i + j) - 'a' + 1) * ps[j] % modulo) % modulo;
            }
            if (hash == hashValue) {
                return s.substring(i, i + k);
            }
        }
        return null;
    }

    public String subStrHash1(String s, int power, int modulo, int k, int hashValue) {
        long hash = 0;
        long p = 1;
        int n = s.length();
        int idx = n - k;
        for (int i = n - 1; i >= n - k; i--) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash * power + val) % modulo;
            p = p * power % modulo;
        }
        for (int i = n - k - 1; i >= 0; i--) {
            int val1 = s.charAt(i) - 'a' + 1;
            int val2 = s.charAt(i + k) - 'a' + 1;
            //+modulo是修正余数为非负数
            hash = (hash * power + val1 - val2 * p % modulo + modulo) % modulo;
            if (hash == hashValue) {
                idx = i;
            }
        }
        return s.substring(idx, idx + k);
    }

    public String subStrHash2(String s, int power, int modulo, int k, int hashValue) {
        long h = 0, p = 1, index = s.length() - k;
        for (int i = s.length() - 1; i >= s.length() - k; i--) {
            h = (h * power + s.charAt(i) - 'a' + 1) % modulo;
            p = p * power % modulo;
        }
        for (int i = s.length() - k - 1; i >= 0; i--) {
            int val1 = s.charAt(i) - 'a' + 1;
            int val2 = s.charAt(i + k) - 'a' + 1;
            h = (h * power + val1 - val2 * p % modulo + modulo) % modulo;
            if (h == hashValue) {
                index = i;
            }
        }
        return s.substring((int) index, (int) index + k);
    }
}
