package com.carter.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Item692 {
    public static void main(String[] args) {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Item692().topKFrequent(arr, 3));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Queue<Map.Entry<String, Long>> minHeap = new PriorityQueue<>(k + 1,
                (e1, e2) -> e1.getValue().compareTo(e2.getValue()) != 0 ?
                        e1.getValue().compareTo(e2.getValue()) :
                        -e1.getKey().compareTo(e2.getKey()));
        Stream.of(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(entry -> {
                    minHeap.offer(entry);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                });
        String[] rs = new String[k];
        int i = k;
        while (minHeap.size() > 0) {
            rs[i - 1] = minHeap.poll().getKey();
            i--;
        }
        return Arrays.asList(rs);
    }

}
