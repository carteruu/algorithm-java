package com.carter.leet;

import java.util.Objects;

public class Item1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0;
        int i2 = 0;
        while (true) {
            String w1 = word1[i1];
            String w2 = word2[i2];
            int c1 = w1.length()-1;
            int c2 = w2.length()-1;
            while (true){
                if (w1.charAt(c1) != w2.charAt(c2)) {
                    return false;
                }

            }

        }
    }

    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) {
            return true;
        }
        if (word1 == null || word2 == null) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String word : word1) {
            sb1.append(word);
        }
        for (String word : word2) {
            sb2.append(word);
        }
        return Objects.equals(sb1.toString(), sb2.toString());
    }
}
