package com.carter.leetcode;

public class Item686 {
    public int repeatedStringMatch2(String a, String b) {
//        if (a.contains(b)) {
//            return 1;
//        }
//        if ()
            return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int lengthA = a.length();
        int lengthB = b.length();
        for (int i = 0; i < lengthA; i++) {
            int idxA = i, idxB = 0;
            for (; idxB < lengthB; idxA++, idxB++) {
                if (charsA[idxA % lengthA] != charsB[idxB]) {
                    break;
                }
            }
            if (idxB == lengthB) {
                return idxA / lengthA + (idxA % lengthA == 0 ? 0 : 1);
            }
        }
        return -1;
    }
}
