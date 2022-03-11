package com.carter.leet;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Item1705 {
    /**
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples2(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) {
                q.add(new int[]{time + days[time] - 1, apples[time]});
            }
            while (!q.isEmpty() && q.peek()[0] < time) {
                q.poll();
            }
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) {
                    q.add(cur);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }

    /**
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        int time = 0;
        //小顶堆,过期时间早的在堆顶
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.comparingInt(o -> o + days[o]));
        int n = apples.length;
        while (time < n) {
            //删掉已过期,或者没有苹果的下标
            while (min.size() > 0 && (min.peek() + days[min.peek()] <= time || apples[min.peek()] <= 0)) {
                min.poll();
            }
            //当天,树上长出苹果,则加入堆
            if (apples[time] > 0) {
                min.offer(time);
            }
            //堆中存在苹果,则答案+1
            if (min.size() > 0) {
                ans++;
                apples[min.peek()]--;
            }
            time++;
        }
        while (min.size() > 0) {
            int poll = min.poll();
            //如果苹果未腐烂
            if (poll + days[poll] - 1 >= time) {
                //可以吃的苹果数:min(苹果数,苹果腐烂的剩余时间闭区间)
                int eat = Math.min(apples[poll], poll + days[poll] - 1 - time + 1);
                //增加吃的苹果数,并往前推动时间
                ans += eat;
                time += eat;
            }
        }
        return ans;
    }

    /**
     * TODO 有问题
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples1(int[] apples, int[] days) {
        //苹果最后腐烂时间
        int lastDay = 0;
        for (int i = 0; i < apples.length; i++) {
            lastDay = Math.max(lastDay, i + days[i] - 1);
        }
        int[] rotDay = new int[lastDay + 1];
        int ans = 0, start = lastDay, end = 0;
        for (int i = 0; i < lastDay + 1; i++) {
            if (i < apples.length && apples[i] > 0) {
                rotDay[i + days[i] - 1] = apples[i];
                start = Math.min(start, i + days[i] - 1);
                end = Math.max(end, i + days[i] - 1);
            }
            start = Math.max(start, i);
            for (; start <= end; start++) {
                if (rotDay[start] > 0) {
                    ans++;
                    rotDay[start]--;
                    break;
                }
            }
        }
        return ans;
    }

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int ans = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            int n = apples.length;
            int i = 0;
            while (i < n) {
                while (!pq.isEmpty() && pq.peek()[0] <= i) {
                    pq.poll();
                }
                int rottenDay = i + days[i];
                int count = apples[i];
                if (count > 0) {
                    pq.offer(new int[]{rottenDay, count});
                }
                if (!pq.isEmpty()) {
                    int[] arr = pq.peek();
                    arr[1]--;
                    if (arr[1] == 0) {
                        pq.poll();
                    }
                    ans++;
                }
                i++;
            }
            while (!pq.isEmpty()) {
                while (!pq.isEmpty() && pq.peek()[0] <= i) {
                    pq.poll();
                }
                if (pq.isEmpty()) {
                    break;
                }
                int[] arr = pq.poll();
                int curr = Math.min(arr[0] - i, arr[1]);
                ans += curr;
                i += curr;
            }
            return ans;
        }
    }

}
