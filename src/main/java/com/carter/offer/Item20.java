package com.carter.offer;

import java.util.*;

public class Item20 {
    private Map<String, Set<String>> map = new HashMap<>();

    {
        map.put("start", new HashSet<>(Arrays.asList("num", "e", "end", "point")));
        map.put("sign", new HashSet<>(Arrays.asList("num")));
        map.put("num", new HashSet<>(Arrays.asList("num", "e", "end", "point")));
        map.put("e", new HashSet<>(Arrays.asList("num")));
    }

    public boolean isNumber(String s) {
        String state = "start";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if(c=='e'||c=='E'){
                if(!map.get(state).contains("e")){

                }
            }
        }
        return map.get(state).contains("end");
    }
}
