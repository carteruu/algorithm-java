package com.carter.leet;

import java.util.*;

public class Item2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        //都按从大到小排序
        Arrays.sort(tasks);
        Arrays.sort(workers);
        //最大答案和最小答案
        int min = 0;
        int max = Math.min(tasks.length, workers.length) - 1;
        //二分
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    /**
     * 从下标0到下标mid的任务(最小的mid+1个任务),
     * 是否都能被workers.length - 1 - mid到workers.length - 1下标的工人(力量最大的mid+1个工人)完成
     *
     * @param tasks
     * @param workers
     * @param pills
     * @param strength
     * @param mid
     * @return
     */
    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        //工人队列
        Deque<Integer> workerDeque = new ArrayDeque<>();
        int workerIdx = workers.length - 1;
        int workerIdxMin = workers.length - 1 - mid;
        //从大到小遍历任务
        for (int i = mid; i >= 0; i--) {
            while (workerIdx >= workerIdxMin && workers[workerIdx] + strength >= tasks[i]) {
                //从力量最大的工人开始遍历,如果工人吃药丸后,能够完成当前任务,加入队尾
                workerDeque.addLast(workers[workerIdx]);
                workerIdx--;
            }
            if (workerDeque.size() == 0) {
                //没有工人能够完成当前任务
                return false;
            }
            if (workerDeque.getFirst() >= tasks[i]) {
                //队头(队列中,力量最大)的工人可以完成当前任务,让他去完成当前任务.
                workerDeque.removeFirst();
            } else {
                //队头(队列中,力量最大)的工人不能完成当前任务,需要吃药丸
                if (pills == 0) {
                    //没有药丸了
                    return false;
                } else {
                    pills--;
                    //让队里力量最小的工人吃了药丸去完成当前任务.
                    // 因为任务需要的力量是递减的,力量大的工人有可能不吃药丸完成后面的任务
                    workerDeque.removeLast();
                }
            }
        }
        return true;
    }

    public int maxTaskAssign1(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int worker : workers) {
            workerMap.put(worker, workerMap.getOrDefault(worker, 0) + 1);
        }
        int ans = 0;
        int l = 0, r = tasks.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (helper(tasks, new TreeMap<>(workerMap), pills, strength, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }

    private boolean helper(int[] tasks, TreeMap<Integer, Integer> workerMap, int pills, int strength, int mid) {
        for (int i = mid; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceilingEntry = workerMap.ceilingEntry(tasks[i]);
            if (ceilingEntry != null) {
                //不使用药丸
                if (ceilingEntry.getValue() > 1) {
                    workerMap.put(ceilingEntry.getKey(), ceilingEntry.getValue() - 1);
                } else {
                    workerMap.remove(ceilingEntry.getKey());
                }
            } else {
                //使用药丸
                if (pills == 0) {
                    return false;
                }
                pills--;
                Map.Entry<Integer, Integer> entry = workerMap.ceilingEntry(tasks[i] - strength);
                if (entry != null) {
                    if (entry.getValue() > 1) {
                        workerMap.put(entry.getKey(), entry.getValue() - 1);
                    } else {
                        workerMap.remove(entry.getKey());
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            Arrays.sort(tasks);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int worker : workers) {
                map.put(worker, map.getOrDefault(worker, 0) + 1);
            }
            int left = 0, right = tasks.length;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (maxTaskAssign(mid, tasks, new TreeMap<>(map), pills, strength)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean maxTaskAssign(int k, int[] tasks, TreeMap<Integer, Integer> map, int pills, int strength) {
            for (int i = k - 1; i >= 0; i--) {
                if (map.ceilingKey(tasks[i]) != null) {
                    map.put(map.ceilingKey(tasks[i]), map.ceilingEntry(tasks[i]).getValue() - 1);
                    if (map.get(map.ceilingKey(tasks[i])) == 0) {
                        map.remove(map.ceilingKey(tasks[i]));
                    }
                } else if (map.ceilingKey(tasks[i] - strength) != null && pills-- > 0) {
                    map.put(map.ceilingKey(tasks[i] - strength), map.ceilingEntry(tasks[i] - strength).getValue() - 1);
                    if (map.get(map.ceilingKey(tasks[i] - strength)) == 0) {
                        map.remove(map.ceilingKey(tasks[i] - strength));
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
