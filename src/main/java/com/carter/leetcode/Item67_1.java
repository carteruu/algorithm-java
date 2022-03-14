package com.carter.leetcode;

public class Item67_1 {
    public String addBinary(String a, String b) {
        int pa = a.length() - 1, pb = b.length() - 1;
        int c = 0;
        StringBuilder ss = new StringBuilder();
        while (pa >= 0 || pb >= 0) {
            int numA = pa >= 0 ? a.charAt(pa) - '0' : 0;
            int numB = pb >= 0 ? b.charAt(pb) - '0' : 0;
            int n = numA + numB + c;
            c = n / 2;
            ss.append(n % 2);
            pa--;
            pb--;
        }
        if (c > 0) {
            ss.append(c);
        }
        ss.reverse();
        return ss.toString();
    }
}
