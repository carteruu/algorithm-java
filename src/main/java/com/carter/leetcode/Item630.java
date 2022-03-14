package com.carter.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Item630 {
    // 贪心 + 排序 + 优先级队列（大根堆）
    // 先按课程的截止时间由小到大排序；
    // 再遍历课程，依次考察是否可选：1）用一个变量维持当前时间，选择后更新当前时间；2）用一个大根堆维持已被选中的课程，大根堆根据课程的持续时间组织；
    // 课程可选的条件是：1）当前时间+该课程持续时间<=该课程截止时间；
    // 2）当前时间+该课程持续时间 > 该课程截止时间 && 该课程持续时间 < 堆顶课程的持续时间，此时选择该课程，淘汰堆顶课程；
    public  int scheduleCourse3(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int curTime = 0;
        for (int[] course : courses) {
            int nextTime = curTime + course[0];
            if (nextTime <= course[1]) {
                maxHeap.add(course);
                curTime = nextTime;
            } else if (!maxHeap.isEmpty() && course[0] < maxHeap.peek()[0]) {
                int[] c = maxHeap.poll();
                curTime -= c[0];
                maxHeap.add(course);
                curTime += course[0];
            }
        }
        return maxHeap.size();
    }

    public int scheduleCourse(int[][] courses) {
        if (courses.length == 0) {
            return 0;
        }
        //按课程的结束时间排序
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        //课程的最晚结束时间
        int max = Arrays.stream(courses).mapToInt(c -> c[1]).max().getAsInt();
        //原来是二维的dp数组(课程编号,结束时间),使用状态压缩,只保留结束时间.值是可以修读的课程数
        int[] dp = new int[max + 1];
        int ans = 0;
        //遍历每一个课程
        for (int i = 1; i <= courses.length; i++) {
            //对于当前遍历的课程,结束时间的取值范围为[课程的耗时,课程最晚的结束时间]
            for (int j = courses[i - 1][1]; j >= courses[i - 1][0]; j--) {
                //更新可以修读的课程数量,并更新答案
                dp[j] = Math.max(dp[j], dp[j - courses[i - 1][0]] + 1);
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }

    public int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        return dfs(courses, 0, 0);
    }

    private int dfs(int[][] courses, int idx, int time) {
        if (idx == courses.length) {
            return 0;
        }
        //不选择
        int rs = dfs(courses, idx + 1, time);
        if (time + courses[idx][0] <= courses[idx][1]) {
            rs = Math.max(rs, dfs(courses, idx + 1, time + courses[idx][0]) + 1);
        }
        return rs;
    }
}
