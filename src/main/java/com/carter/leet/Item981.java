package com.carter.leet;

import java.util.*;

public class Item981 {
    public static class TimeMap {
        private final Map<String, List<Item>> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Item> items = map.computeIfAbsent(key, k -> new ArrayList<>());
            items.add(new Item(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Item> items = map.get(key);
            if (items == null || items.get(0).timestamp > timestamp) {
                //key不存在,或timestamp比列表的第一个还小,直接返回空字符串
                return "";
            }
            //二分查找到比timestamp小的最大元素
            int s = 0;
            int e = items.size() - 1;
            while (s < e) {
                int mid = (e + s + 1) >> 1;
                Item item = items.get(mid);
                if (item.timestamp == timestamp) {
                    return item.value;
                } else if (item.timestamp > timestamp) {
                    //mid的时间戳比目标大,排除
                    e = mid - 1;
                } else {
                    s = mid;
                }
            }
            return items.get(e).value;
        }

        private static class Item {
            public Item(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            String value;
            int timestamp;
        }
    }
}
