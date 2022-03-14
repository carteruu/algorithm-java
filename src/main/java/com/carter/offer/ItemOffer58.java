package com.carter.offer;

public class ItemOffer58 {
    public String reverseLeftWords(String s, int n) {
        String rs = s.substring(n);
        return rs + s.substring(0, n);
    }
}
