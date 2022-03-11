package com.carter.leet;

import java.util.Map;
import java.util.TreeMap;

public class Item12 {
    private static class Pair {
        public Pair(int num, String flag) {
            this.num = num;
            this.flag = flag;
        }

        int num;
        String flag;
    }

    public String intToRoman(int num) {
        Pair[] pairs = new Pair[]{
                new Pair(1, "I"),
                new Pair(4, "IV"),
                new Pair(5, "V"),
                new Pair(9, "IX"),
                new Pair(10, "X"),
                new Pair(40, "XL"),
                new Pair(50, "L"),
                new Pair(90, "XC"),
                new Pair(100, "C"),
                new Pair(400, "CD"),
                new Pair(500, "D"),
                new Pair(900, "CM"),
                new Pair(1000, "M")
        };
        StringBuilder sb = new StringBuilder();
        for (int i = pairs.length - 1; i >= 0; i--) {
            Pair pair = pairs[i];
            int t = num / pair.num;
            num -= pair.num * t;
            for (int j = 0; j < t; j++) {
                sb.append(pair.flag);
            }
        }
        return sb.toString();
    }

    public String intToRoman1(int num) {
        Map<Integer, String> numMap = new TreeMap<>((key1, key2) -> key2 - key1);
        numMap.put(1, "I");
        numMap.put(4, "IV");
        numMap.put(5, "V");
        numMap.put(9, "IX");
        numMap.put(10, "X");
        numMap.put(40, "XL");
        numMap.put(50, "L");
        numMap.put(90, "XC");
        numMap.put(100, "C");
        numMap.put(400, "CD");
        numMap.put(500, "D");
        numMap.put(900, "CM");
        numMap.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : numMap.entrySet()) {
            int t = num / entry.getKey();
            num -= entry.getKey() * t;
            for (int i = 0; i < t; i++) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
