package com.carter.leet;

import java.util.ArrayList;
import java.util.List;

public class Item2081 {
    public long kMirror(int k, int n) {
        long ans = 0;
        int cnt = 0;
        int digit = 1;
        while (cnt < n) {
            List<String> mirror = this.mirror(k, digit);
            for (String m : mirror) {
                long num = Long.parseLong(m, k);
                if (m.charAt(0) != '0' && this.check(String.valueOf(num))) {
                    ans += num;
                    cnt++;
                    if (cnt == n) {
                        break;
                    }
                }
            }
            digit++;
        }
        return ans;
    }

    private List<String> mirror(int k, int digit) {
        List<String> ans = new ArrayList<>();
        if (digit == 0) {
            ans.add("");
        } else if (digit == 1) {
            for (int i = 0; i < k; i++) {
                ans.add(String.valueOf(i));
            }
        } else {
            List<String> mirror = mirror(k, digit - 2);
            for (int i = 0; i < k; i++) {
                for (String m : mirror) {
                    ans.add(i + m + i);
                }
            }
        }
        return ans;
    }

    private boolean check(String num) {
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static class Solution {

        public long kMirror(int k, int n) {
            long sum = 0;
            for (int i = 1; i < 10; i++) {
                if (kMirror(Long.toString(i, k))) {
                    sum += i;
                    if (--n == 0) {
                        return sum;
                    }
                }
            }
            for (int i = 0; ; i++) {
                for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                    if (kMirror(Long.toString(Long.parseLong("" + j + new StringBuilder("" + j).reverse()), k))) {
                        sum += Long.parseLong("" + j + new StringBuilder("" + j).reverse());
                        if (--n == 0) {
                            return sum;
                        }
                    }
                }
                for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                    for (int l = 0; l < 10; l++) {
                        if (kMirror(Long.toString(Long.parseLong("" + j + l + new StringBuilder("" + j).reverse()), k))) {
                            sum += Long.parseLong("" + j + l + new StringBuilder("" + j).reverse());
                            if (--n == 0) {
                                return sum;
                            }
                        }
                    }
                }
            }
        }

        private boolean kMirror(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class Solution1 {
        public long kMirror(int k, int n) {
            return getN(k, n);
        }

        private long getN(int k, int n) {
            int i = 0;
            int digit = 1;
            long lret = 0;
            while (i < n) {
                List<String> nums = getNDigit(k, digit);
                for (int j = 0; j < nums.size() && i < n; ++j) {
                    String num = nums.get(j);
                    if (num.charAt(0) == '0') {
                        continue;
                    }
                    long tenV = tenVal(k, num);
                    if (isTenValid(tenV)) {
                        ++i;
                        lret += tenV;
                    }
                }
                ++digit;
            }
            return lret;
        }

        private List<String> getNDigit(int k, int len) {
            if (len == 0) {
                return new ArrayList<>();
            }
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < k; ++i) {
                ret.add(String.valueOf(i));
            }
            if (len == 1) {
                return ret;
            }

            List<String> res = new ArrayList<>();
            List<String> sub = getNDigit(k, len - 2);
            for (int i = 0; i < k; ++i) {
                if (sub.size() > 0) {
                    for (String s : sub) {
                        res.add(i + s + i);
                    }
                } else {
                    res.add(i + "" + i);
                }
            }
            return res;
        }

        private long tenVal(int k, String knum) {
            long ret = 0;
            for (int i = knum.length() - 1; i >= 0; --i) {
                ret += Math.pow(k, (knum.length() - 1) - i) * (knum.charAt(i) - '0');
            }
            return ret;
        }

        private boolean isTenValid(long ret) {
            String sret = String.valueOf(ret);
            int i = 0, j = sret.length() - 1;
            while (i < j) {
                if (sret.charAt(i) != sret.charAt(j)) {
                    return false;
                }
                ++i;
                --j;
            }
            return true;
        }
    }
}

