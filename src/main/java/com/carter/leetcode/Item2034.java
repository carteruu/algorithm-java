package com.carter.leetcode;

import java.util.*;

public class Item2034 {
    public static class StockPrice2 {
        //最新的价格:[时间,价格]
        private int[] curr = new int[2];
        //时间->价格
        private Map<Integer, Integer> map;
        //时间->价格
        private TreeSet<Integer> set;


        public StockPrice2() {
            map = new HashMap<>();
            set = new TreeSet<>(Comparator.comparingInt(t -> map.get(t)));
        }

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)) {
                set.remove(timestamp);
            }
            map.put(timestamp, price);
            set.add(timestamp);
            //更新最新价格
            if (timestamp >= curr[0]) {
                curr[0] = timestamp;
                curr[1] = price;
            }
        }

        public int current() {
            return curr[1];
        }

        public int maximum() {
            return map.get(set.last());
        }

        public int minimum() {
            return map.get(set.first());
        }
    }

    public static class StockPrice {
        //最新的价格,只需要一个时间戳最大的值:[时间,价格]
        private int[] curr = new int[2];
        //所有时间戳的最新价格,时间->价格
        private Map<Integer, Integer> cache;
        //小顶堆,按价格:[时间,价格]
        private PriorityQueue<int[]> min;
        //大顶堆,按价格:[时间,价格]
        private PriorityQueue<int[]> max;

        public StockPrice() {
            cache = new HashMap<>();
            //按价格倒序排列
            max = new PriorityQueue<>((t1, t2) -> t2[1] - t1[1]);
            //按价格顺序排列
            min = new PriorityQueue<>(Comparator.comparingInt(t -> t[1]));
        }

        public void update(int timestamp, int price) {
            //加入时间价格映射,入队
            //这里我最初使用的方法,判断时间戳在cache中存在时,调用PriorityQueue的remove方法出队,
            //发现remove方法的时间复杂度是O(n),超时
            cache.put(timestamp, price);
            min.offer(new int[]{timestamp, price});
            max.offer(new int[]{timestamp, price});
            //更新最新价格
            if (timestamp >= curr[0]) {
                curr[0] = timestamp;
                curr[1] = price;
            }
        }

        public int current() {
            return curr[1];
        }

        public int maximum() {
            //堆顶的价格和cache不同时,说明已经是旧数据,丢弃数据
            while (cache.get(max.peek()[0]) != max.peek()[1]) {
                max.poll();
            }
            return max.peek()[1];
        }

        public int minimum() {
            while (cache.get(min.peek()[0]) != min.peek()[1]) {
                min.poll();
            }
            return min.peek()[1];
        }
    }
}
