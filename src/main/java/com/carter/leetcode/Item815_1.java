package com.carter.leetcode;

import java.util.*;

public class Item815_1 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //路线当做点

        Map<Integer, Set<Integer>> site2Line = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int site : routes[i]) {
                Set<Integer> set = site2Line.getOrDefault(site, new HashSet<>());
                set.add(i);
                site2Line.put(site, set);
            }
        }
        Map<Integer, Set<Integer>> line2Line = new HashMap<>(routes.length);
        for (int i = 0; i < routes.length; i++) {
            for (int site : routes[i]) {
                Set<Integer> lines = site2Line.get(site);
                for (int line : lines) {
                    Set<Integer> lineSet = line2Line.getOrDefault(i, new HashSet<>());
                    lineSet.add(line);
                    line2Line.put(i, lineSet);
                }
            }
        }

        int rs = 0;
        Queue<Integer> queueSrc = new ArrayDeque<>();
        Queue<Integer> queueDesc = new ArrayDeque<>();
        Queue<Integer> queue = queueSrc;
        Set<Integer> setSrc = new HashSet<>();
        Set<Integer> setDesc = new HashSet<>();
        Set<Integer> set = setSrc;
        Set<Integer> setTarget = setDesc;
        if(site2Line.containsKey(source)) {
            for (Integer line1 : site2Line.get(source)) {
                queueSrc.offer(line1);
                setSrc.add(line1);
            }
        }
        if(site2Line.containsKey(target)) {
            for (Integer integer : site2Line.get(target)) {
                queueDesc.offer(integer);
                setDesc.add(integer);
            }
        }
        while (queue.size() > 0) {
            rs++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (Integer line : line2Line.get(poll)) {
                    if (setTarget.contains(line)) {
                        return rs;
                    }
                    if (!set.contains(line)) {
                        queue.add(line);
                        set.add(line);
                    }
                }
            }
            if (queueSrc.size() < queueDesc.size()) {
                queue = queueSrc;
                set = setSrc;
                setTarget = setDesc;
            } else {
                queue = queueDesc;
                set = setDesc;
                setTarget = setSrc;
            }
        }
        return -1;
    }
}
