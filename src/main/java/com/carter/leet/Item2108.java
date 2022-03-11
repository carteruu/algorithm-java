package com.carter.leet;

public class Item2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            boolean isFind = true;
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                return word;
            }
        }
        return "";
    }
}
