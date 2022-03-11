package com.carter.leet;

public class Item2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ss = new StringBuilder(s.length() + spaces.length);
        int start = 0;
        for (int space : spaces) {
            ss.append(s, start, space);
            ss.append(" ");
            start = space;
        }
        ss.append(s, start, s.length());
        return ss.toString();
    }
}
