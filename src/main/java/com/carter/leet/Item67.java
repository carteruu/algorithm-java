package com.carter.leet;

public class Item67 {
    public String addBinary(String a, String b) {
        int c = 0;
        StringBuilder sb = new StringBuilder();
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        while (pa >= 0 || pb >= 0) {
            int sum = (pa >= 0 ? a.charAt(pa) - '0' : 0) + (pb >= 0 ? b.charAt(pb) - '0' : 0) + c;
            c = sum >> 1;
            sb.append(sum % 2);
            pa--;
            pb--;
        }
        if (c == 1) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
