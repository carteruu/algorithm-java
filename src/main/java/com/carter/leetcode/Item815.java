package com.carter.leetcode;

import java.util.*;

public class Item815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int rs = 0;
        Queue<Integer> queueSrc = new ArrayDeque<>();
        queueSrc.offer(source);
        Queue<Integer> queueDesc = new ArrayDeque<>();
        queueDesc.offer(target);
        Queue<Integer> queue = queueSrc;

        Set<Integer> setSrc = new HashSet<>();
        setSrc.add(source);
        Set<Integer> setDesc = new HashSet<>();
        setDesc.add(target);
        Set<Integer> set = setSrc;
        Set<Integer> setTarget = setDesc;

        Map<Integer, Set<Integer>> map = new HashMap<>(routes.length);
        for (int[] route : routes) {
            Set<Integer> c = new HashSet<>(route.length);
            for (int e : route) {
                c.add(e);
            }
            for (int e : route) {
                map.putIfAbsent(e, new HashSet<>());
                map.get(e).addAll(c);
                map.get(e).remove(e);
            }
        }
        while (queue.size() > 0) {
            rs++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                Set<Integer> next = map.get(poll);
                for (int n : next) {
                    if (!set.contains(n)) {
                        if (setTarget.contains(n)) {
                            return rs;
                        }
                        queue.offer(n);
                        set.add(n);
                    }
                }
            }
            if (queueSrc.size() <= queueDesc.size()) {
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
