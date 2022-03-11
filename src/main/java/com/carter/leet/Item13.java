package com.carter.leet;

import java.util.HashMap;
import java.util.Map;

public class Item13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int rs = 0;
        int i = 0;
        Integer val ;
        Integer nextVal = map.get(s.charAt(i));
        while (i < s.length()) {
            val = nextVal;
            if (i + 1 < s.length()) {
                nextVal = map.get(s.charAt(i + 1));
            }
            if (val < nextVal) {
                rs -= val;
                rs += nextVal;
                i += 2;
            } else {
                rs += val;
                i++;
            }
        }
        return rs;
    }
}
