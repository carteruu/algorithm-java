package com.carter.leet;

import java.util.*;

public class Item2059 {
    /**
     * TODO 双向遍历,还有问题:小于0或大于1000时,不能变换
     *
     * @param nums
     * @param start
     * @param goal
     * @return
     */
    public int minimumOperations(int[] nums, int start, int goal) {
        int min = 0;
        int max = 1000;
        Map<Integer, Integer> steps1 = new HashMap<>(max);
        steps1.put(start, 0);
        Map<Integer, Integer> steps2 = new HashMap<>(max);
        steps2.put(goal, 0);
        Queue<Integer> queue1 = new ArrayDeque<>(max);
        queue1.offer(start);
        Queue<Integer> queue2 = new ArrayDeque<>(max);
        queue2.offer(goal);
        while (queue1.size() > 0 || queue2.size() > 0) {
            Integer step;
            if (queue1.size() != 0 && queue1.size() <= queue2.size()) {
                step = bfs(nums, min, max, queue1, steps1, steps2);
            } else {
                step = bfs(nums, min, max, queue2, steps2, steps1);
            }
            if (step != null) {
                return step;
            }
        }
        return -1;
    }

    private Integer bfs(int[] nums, int min, int max, Queue<Integer> queue, Map<Integer, Integer> sourceSteps, Map<Integer, Integer> targetSteps) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int poll = queue.poll();
            int step = sourceSteps.get(poll) + 1;
            for (int num : nums) {
                int[] next = new int[]{poll + num, poll - num, poll ^ num};
                for (int n : next) {
                    if (targetSteps.containsKey(n)) {
                        return step + targetSteps.get(n);
                    }
                    if (n < min || n > max || sourceSteps.containsKey(n)) {
                        continue;
                    }
                    sourceSteps.put(n, step);
                    queue.offer(n);
                }
            }
        }
        return null;
    }

    public int minimumOperations1(int[] nums, int start, int goal) {
        int max = 1000;
        Queue<Integer> deque = new ArrayDeque<>(max);
        deque.offer(start);
        //记录哪些中间值已经被访问过
        boolean[] seen = new boolean[max + 1];
        int step = 0;
        //BFS
        while (deque.size() > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int poll = deque.poll();
                if (poll == goal) {
                    //找到目标值
                    return step;
                }
                //非目标值
                //判断是否超过范围,或已被访问过
                if (poll < 0 || poll > max || seen[poll]) {
                    continue;
                }
                for (int num : nums) {
                    deque.offer(poll + num);
                    deque.offer(poll - num);
                    deque.offer(poll ^ num);
                }
                seen[poll] = true;
            }
            step++;
        }
        return -1;
    }

    class Solution {

        public int minimumOperations(int[] nums, int start, int goal) {
            boolean[] visited = new boolean[1001];
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.add(start);
            for (int i = 0; !deque.isEmpty(); i++) {
                for (int j = deque.size(); j > 0; j--) {
                    int poll = deque.poll();
                    if (poll == goal) {
                        return i;
                    } else if (poll >= 0 && poll <= 1000 && !visited[poll]) {
                        visited[poll] = true;
                        for (int num : nums) {
                            deque.offer(poll + num);
                            deque.offer(poll - num);
                            deque.offer(poll ^ num);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
