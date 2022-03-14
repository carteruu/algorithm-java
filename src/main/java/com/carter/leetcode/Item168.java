package com.carter.leetcode;

public class Item168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int zero = 'A';
        while (columnNumber > 0) {
            columnNumber -= 1;
            sb.append((char) (columnNumber % 26 + zero));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
