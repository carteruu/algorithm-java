package com.carter.leet;

import java.util.*;

public class Item752_1 {
    public int openLock(String[] deadends, String target) {
        int startInt = 0;
        int targetInt = Integer.parseInt(target);
        if (startInt == targetInt) {
            return 0;
        }
        boolean[] deadSet = new boolean[10000];
        for (String d : deadends) {
            deadSet[Integer.parseInt(d)] = true;
        }
        if (deadSet[startInt]) {
            return -1;
        }
        Queue<Integer> queueStart = new ArrayDeque<>(5000);
        queueStart.offer(startInt);
        int[] timesMapStart = new int[10000];
        Arrays.fill(timesMapStart, -1);
        timesMapStart[startInt] = 0;

        Queue<Integer> queueTarget = new ArrayDeque<>(5000);
        queueTarget.offer(targetInt);
        int[] timesMapTarget = new int[10000];
        Arrays.fill(timesMapTarget, -1);
        timesMapTarget[targetInt] = 0;

        while (queueStart.size() > 0 && queueTarget.size() > 0) {
            Integer ans;
            if (queueStart.size() <= queueTarget.size()) {
                ans = bfs(queueStart, timesMapStart, timesMapTarget, deadSet);
            } else {
                ans = bfs(queueTarget, timesMapTarget, timesMapStart, deadSet);
            }
            if (ans != null) {
                return ans;
            }
        }
        return -1;
    }

    /**
     * 双向BFS
     *
     * @param queue
     * @param curMap
     * @param otherMap
     * @param deadSet
     * @return
     */
    private Integer bfs(Queue<Integer> queue, int[] curMap, int[] otherMap, boolean[] deadSet) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int poll = queue.poll();
            int times = curMap[poll] + 1;
            for (int j = 1; j < 10000; j *= 10) {
                int[] next = new int[2];
                int s = poll / j % 10;
                //增加数值
                if (s == 9) {
                    next[0] = poll - 9 * j;
                } else {
                    next[0] = poll + j;
                }
                //减少
                if (s == 0) {
                    next[1] = poll + 9 * j;
                } else {
                    next[1] = poll - j;
                }

                for (int n : next) {
                    if (deadSet[n]) {
                        //死亡数字
                        continue;
                    }
                    if (otherMap[n] != -1) {
                        //找到答案
                        return times + otherMap[n];
                    }
                    if (curMap[n] != -1) {
                        //已访问过
                        continue;
                    }
                    //加入队列
                    queue.add(n);
                    curMap[n] = times;
                }
            }
        }
        return null;
    }

//    public int openLock1(String[] deadends, String target) {
//        String start = "0000";
//        if (start.equals(target)) {
//            return 0;
//        }
//        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
//        if (deadSet.contains(start)) {
//            return -1;
//        }
//        Queue<String> queue = new ArrayDeque<>();
//        queue.offer(start);
//        int times = 0;
//        while (queue.size() > 0) {
//            times++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String poll = queue.poll();
//                char[] pollChars = poll.toCharArray();
//                for (int j = 0; j < poll.length(); j++) {
//                    //往前拨动
//                    next(pollChars, j, true);
//                    String next = new String(pollChars);
//                    if (!deadSet.contains(next)) {
//                        if (next.equals(target)) {
//                            return times;
//                        }
//                        //加入队列
//                        queue.add(next);
//                        //避免重复访问
//                        deadSet.add(next);
//                    }
//                    next(pollChars, j, false);
//                    //往后拨动
//                    next(pollChars, j, false);
//                    next = new String(pollChars);
//                    if (!deadSet.contains(next)) {
//                        if (next.equals(target)) {
//                            return times;
//                        }
//                        queue.add(next);
//                        deadSet.add(next);
//                    }
//                    next(pollChars, j, true);
//                }
//            }
//        }
//        return -1;
//    }
}
