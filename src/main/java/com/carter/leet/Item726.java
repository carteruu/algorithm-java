package com.carter.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Item726 {
    public String countOfAtoms(String formula) {
        char[] f = formula.toCharArray();
        Map<String, Integer> map = new TreeMap<>(helper(f, 0, f.length - 1));
        StringBuilder rs = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rs.append(entry.getKey());
            if (entry.getValue() > 1) {
                rs.append(entry.getValue());
            }
        }
        return rs.toString();
    }

    private Map<String, Integer> helper(char[] formula, int start, int end) {
        int i = start;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder atomsSb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        while (i <= end) {
            char c = formula[i];
            if ('A' <= c && c <= 'Z') {
                //将上一个原子存到map
                save(map, atomsSb, numSb);
                //新的原子
                atomsSb.append(c);
            }
            if ('a' <= c && c <= 'z') {
                atomsSb.append(c);
            }
            if ('0' <= c && c <= '9') {
                numSb.append(c);
            }
            if (c == '(') {
                Stack<Character> stack = new Stack<>();
                stack.push(c);
                i++;
                int s = i;
                while (stack.size() > 0) {
                    if (formula[i] == ')') {
                        while (stack.pop() != '(') {

                        }
                    } else {
                        stack.push(formula[i]);
                    }
                    i++;
                }
                Map<String, Integer> m = helper(formula, s, i - 2);
                StringBuilder multipleString = new StringBuilder();
                while (i <= end && '0' <= formula[i] && formula[i] <= '9') {
                    multipleString.append(formula[i]);
                    i++;
                }
                int multiple = 1;
                if (multipleString.length() > 0) {
                    multiple = Integer.parseInt(multipleString.toString());
                }
                for (Map.Entry<String, Integer> e : m.entrySet()) {
                    map.put(e.getKey(), map.getOrDefault(e.getKey(), 0) + e.getValue() * multiple);
                }
                i--;
            }
            i++;
        }
        save(map, atomsSb, numSb);

        return map;
    }

    private void save(Map<String, Integer> map, StringBuilder atomsSb, StringBuilder numSb) {
        if (atomsSb.length() == 0) {
            return;
        }
        int num = 1;
        String numStr = numSb.toString();
        if (numStr.length() > 0) {
            num = Integer.parseInt(numStr);
        }
        String atoms = atomsSb.toString();
        map.put(atoms, map.getOrDefault(atoms, 0) + num);
        atomsSb.delete(0, atomsSb.length());
        numSb.delete(0, numSb.length());
    }
}
