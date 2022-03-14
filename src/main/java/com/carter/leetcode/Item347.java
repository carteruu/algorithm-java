package com.carter.leetcode;

import java.util.*;

public class Item347 {
    public int[] topKFrequent3(int[] nums, int k) {
        //最小值,最大值
        int min = 2147483647, max = -2147483648, len = 0, z;
        for (int g : nums) {
            if (g < min) {
                min = g;
            }
            if (g > max) {
                max = g;
            }
        }
        int a[] = new int[max - min + 1];
        max = 0;
        for (int g : nums) {
            if (0 == a[g - min]++) {
                nums[len++] = g;
            }
            z = a[g - min];
            if (z > max) {
                max = z;
            }
        }
        int b[][] = new int[++max][400];
        for (int i = 0, j1, a1; i < len; a1 = nums[i++], z = a[a1 - min], j1 = ++b[z][0], b[z][j1] = a1) {
        }
        int res[] = new int[k];
        while (k != 0) {
            for (int i = b[--max][0], c[] = b[max]; i != 0; res[--k] = c[i--]) {
            }
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public int[] topKFrequent(int[] nums, int k) {
        //最小值,最大值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        //每个元素出现的次数
        int timesMax = 0;
        int[] numTimes = new int[max - min + 1];
        for (int num : nums) {
            int idx = num - min;
            numTimes[idx]++;
            if (numTimes[idx] > timesMax) {
                timesMax = numTimes[idx];
            }
        }
        //计数排序:按元素出现的次数
        List<Integer>[] timesNumList = new ArrayList[timesMax + 1];
        for (int i = 0; i < numTimes.length; i++) {
            int time = numTimes[i];
            if (timesNumList[time] == null) {
                timesNumList[time] = new ArrayList<>();
            }
            timesNumList[time].add(i);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            while (timesNumList[timesMax] == null || timesNumList[timesMax].size() == 0) {
                timesMax--;
            }
            ans[i] = timesNumList[timesMax].remove(timesNumList[timesMax].size() - 1) + min;
        }
        return ans;
    }

    public int[] topKFrequent0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] times = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (times[entry.getValue()] == null) {
                times[entry.getValue()] = new ArrayList<>();
            }
            times[entry.getValue()].add(entry.getKey());
        }
        int[] ans = new int[k];
        int idx = nums.length;
        for (int i = 0; i < k; i++) {
            while (times[idx] == null || times[idx].size() == 0) {
                idx--;
            }
            ans[i] = times[idx].remove(times[idx].size() - 1);
        }
        return ans;
    }
}
