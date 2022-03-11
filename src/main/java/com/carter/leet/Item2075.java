package com.carter.leet;

public class Item2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        StringBuilder ss = new StringBuilder();
        for (int k = 0; k < cols; k++) {
            int i = 0;
            int j = k;
            while (i < rows && j < cols) {
                ss.append(encodedText.charAt(i * cols + j));
                i++;
                j++;
            }
        }
        while (ss.length() > 0 && ss.charAt(ss.length() - 1) == ' ') {
            ss.deleteCharAt(ss.length() - 1);
        }
        return ss.toString();
    }
}
