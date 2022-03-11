package com.carter.leet;

import java.util.*;

public class Item1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodSet = new TreeSet<>();
        Map<Integer, Map<String, Integer>> tableFoodMap = new TreeMap<>();
        for (List<String> order : orders) {
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (!tableFoodMap.containsKey(table)) {
                tableFoodMap.put(table, new HashMap<>());
            }
            Map<String, Integer> foodMap = tableFoodMap.get(table);
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            foodSet.add(food);
        }

        List<List<String>> rs = new ArrayList<>(tableFoodMap.size() + 1);
        ArrayList<String> heads = new ArrayList<>();
        heads.add("Table");
        heads.addAll(foodSet);
        rs.add(heads);
        for (Map.Entry<Integer, Map<String, Integer>> entry : tableFoodMap.entrySet()) {
            ArrayList<String> list = new ArrayList<>(heads.size());
            rs.add(list);
            list.add(entry.getKey() + "");
            Map<String, Integer> value = entry.getValue();
            for (int i = 1; i < heads.size(); i++) {
                list.add(value.getOrDefault(heads.get(i), 0) + "");
            }
        }
        return rs;
    }
}
