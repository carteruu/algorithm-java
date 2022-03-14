package com.carter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item56 {
    public int[][] merge(int[][] intervals) {
        int[] left = new int[10001];
        int[] right = new int[10001];
        for (int[] interval : intervals) {
            left[interval[0]]++;
            right[interval[1]]++;
        }
        List<int[]> res = new ArrayList<>();
        int flag = 0;
        int[] cur = new int[2];
        for (int i = 0; i < left.length; i++) {
            if (left[i] > 0) {
                if (flag == 0) {
                    cur[0] = i;
                }
                flag += left[i];
            }
            if (right[i] > 0) {
                cur[1] = i;
                flag -= right[i];
                if (flag == 0) {
                    res.add(cur);
                    cur = new int[2];
                }
            }
        }
        return res.toArray(new int[][]{});
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<int[]> res = new ArrayList<>();
        int[] pre = Arrays.copyOf(intervals[0], 2);
        res.add(pre);
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if (arr[0] <= pre[1]) {
                //当前区间和上一个区间重叠
                if (arr[1] > pre[1]) {
                    //且比上一个区间的终点更大
                    pre[1] = arr[1];
                }
            } else {
                //不重叠
                pre = Arrays.copyOf(intervals[i], 2);
                res.add(pre);
            }
        }
        return res.toArray(new int[][]{});
    }
}
